package org.scoula.board.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.pagination.Page;
import org.scoula.common.pagination.PageRequest;
import org.scoula.common.util.UploadFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService service;

    @GetMapping("")
    public ResponseEntity<Page> getList(PageRequest pageRequest){
        return ResponseEntity.ok(service.getPage(pageRequest));
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> getBoard(
            @PathVariable Long no){
        return  ResponseEntity.ok(service.get(no));
    }

//    게시글 등록(Multipart/form-data)
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(BoardDTO board){
        return ResponseEntity.ok(service.create(board));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(
            @PathVariable Long no,
        BoardDTO board){
        log.info("put....................");
        return ResponseEntity.ok(service.update(board));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(
            @PathVariable Long no){
        return ResponseEntity.ok(service.delete(no));
    }

//    첨부파일 다운로드
    @GetMapping("/download/{no}")
    public void download(@PathVariable Long no, HttpServletResponse response) throws Exception{
        BoardAttachmentVO attachment=service.getAttachment(no);
        File file=new File(attachment.getPath());
        UploadFiles.download(response,file,attachment.getFilename());
    }

    @DeleteMapping("/deleteAttachment/{no}")
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable Long no)throws Exception{
        return ResponseEntity.ok(service.deleteAttachment(no));
    }


}
