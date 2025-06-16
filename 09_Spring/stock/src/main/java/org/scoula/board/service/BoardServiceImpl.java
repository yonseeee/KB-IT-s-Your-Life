package org.scoula.board.service;

import java.beans.Transient;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final private BoardMapper mapper;
    private final static String BASE_DIR="c:/upload/board";
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

    @Transactional
    @Override
    public void create(BoardDTO board) {
        log.info("create........." + board);
        BoardVO vo = board.toVo(); // DTO -> VO 변환
        mapper.create(vo);

        List<MultipartFile> files = board.getFiles();
        if(files!=null && !files.isEmpty()){
//            upload()
        }
        // DB에서 생성된 PK(no)를 다시 DTO에 반영
        board.setNo(vo.getNo());
    }

    public void upload(Long bno, List<MultipartFile> files){
        for(MultipartFile part:files){
            if (part.isEmpty())continue;
            try{
                String uploadPath= UploadFiles.upload(BASE_DIR,part);

            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update........." + board);
        // update SQL 실행 후 변경된 행이 1개면 true 반환
        return mapper.update(board.toVo()) == 1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete.........." + no);
        // 삭제 SQL 실행후 삭제된 행이 1개면 true
        return mapper.delete(no) == 1;
    }

    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return null;
    }

    @Override
    public boolean deleteAttachment(Long no) {
        return false;
    }
}
