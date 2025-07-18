package org.scoula.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class TimeMapperTest {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    @DisplayName("TimeMapper의 getTime()")
    void getTime() {
//        프록시로 생성된 구현 클래스 이름 출력
        log.info(timeMapper.getClass().getName());
//        실제 DB에서 현재 시간 가져오기
        log.info(timeMapper.getTime());
    }

    @Test
    @DisplayName("TimeMapper의 getTime2()")
    public void getTime2() {
        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }
}