package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Long no;//wrapper type으로 잡은 이유: null 배정하기 위해
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
}
