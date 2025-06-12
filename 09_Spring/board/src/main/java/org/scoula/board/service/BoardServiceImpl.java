package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final private BoardMapper mapper;//생성자가 1개인 경우 생성자 주입으로 초기화
    @Override
    public List<BoardDTO> getList() {
        return mapper.getList().stream()
                .map(BoardDTO::of)//static 메소드 참조
                .toList();
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get......."+no);

        BoardDTO board=BoardDTO.of(mapper.get(no));
//        해당 게시글이 없는 경우 NoSuchElementException 예외 던짐
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void create(BoardDTO board) {
        log.info("create......."+board);
        BoardVO vo=board.tovo();
        mapper.create(vo);
        board.setNo(vo.getNo());


    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update......."+board);
        return mapper.update(board.tovo())==1;

    }

    @Override
    public boolean delete(Long no) {
        log.info("delete......."+no);
//        삭제 SQL 실행 후 삭제된 행이 1개면 true
        return mapper.delete(no)==1;
    }
}
