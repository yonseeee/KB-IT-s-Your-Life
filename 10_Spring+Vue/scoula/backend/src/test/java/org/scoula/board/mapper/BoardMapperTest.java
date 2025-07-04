package org.scoula.board.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)//JUnit과 스프링 통합
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;
    @Test
    void pageData(){
        for(int i=0;i<130;i++){
            BoardVO board = BoardVO.builder()
                    .title("페이지 데이터 "+i)
                    .writer((i%2==0)?"admin":"user0")
                    .content("페이지 내용 "+i)
                    .build();
            mapper.create(board);
        }
    }


}