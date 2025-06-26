package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final private BoardMapper mapper;
    private final static String BASE_DIR = "c:/upload/board";

    @Override
    public List<BoardDTO> getList() {
        log.info("getList.........");

        // mapper에서 VO 목록 받은 후, DTO 변환시킨 전체목록 반환
        return mapper.getList().stream().map(BoardDTO::of).toList();
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get........." + no);
        BoardDTO board = BoardDTO.of(mapper.get(no));
        // 해당 게시글이 없는경우 NoSuchElementException 예외 던짐
        return Optional.ofNullable(board).orElseThrow(NoSuchElementException::new);
    }

    @Transactional//2개 이상의 insert문이 실행될 수 있으므로 필요
//    RuntimeException인 경우만 롤백
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create........." + board);
        BoardVO vo = board.toVo(); // DTO -> VO 변환
        mapper.create(vo);

//        파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if (files != null && !files.isEmpty()) {
            upload(vo.getNo(), files);
        }

        return get(vo.getNo());
    }

    public void upload(Long bno, List<MultipartFile> files) {
        for (MultipartFile part : files) {
            if (part.isEmpty()) continue;//파일이 비어있으면 다음 파일 가져오기
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public BoardDTO update(BoardDTO board) {
        log.info("update........." + board);
        mapper.update(board.toVo());
        // update SQL 실행 후 변경된 행이 1개면 true 반환
        return get(board.getNo());
    }

    @Transactional
    @Override
    public BoardDTO delete(Long no) {
        log.info("delete.........." + no);
        BoardDTO board = get(no);

//        해당 게시글의 첨부파일 목록 가져오기
        List<BoardAttachmentVO> attachList=mapper.getAttachmentList(no);

//        첨부파일 목록 돌면서 첨부파일들 삭제
        for(BoardAttachmentVO attach:attachList){
            mapper.deleteAttachment(attach.getNo());
        }
//        게시글 삭제
        mapper.delete(no);
        return board;
    }

    @Override
    public BoardAttachmentVO getAttachment(Long no) {

        return mapper.getAttachment(no);
    }

    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }
}
