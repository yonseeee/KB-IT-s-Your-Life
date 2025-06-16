package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardAttachmentVO {
    private Long no;
    private Long bno;
    private String filename;
    private String path;
    private String contentType;
    private Long size;
    private Date regDate;

    public static BoardAttachmentVO of(MultipartFile part, Long bno, String path){
        return builder()
                .bno(bno)
                .filename(part.getOriginalFilename())
                .path(path)
                .contentType(part.getContentType())
                .size(part.getSize())
                .build();
    }
}
