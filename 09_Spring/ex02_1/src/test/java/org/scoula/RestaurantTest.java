package org.scoula;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)//스프링 테스트 기능 연동
@ContextConfiguration(classes = {RootConfig.class})//테스트에 사용할 스프링 설정 클래스
@Log4j2
class RestaurantTest {

    @Autowired
    private Restaurant restaurant;

    @Test
    void getChef() {
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("-------------------");
        log.info(restaurant.getChef());
    }
}