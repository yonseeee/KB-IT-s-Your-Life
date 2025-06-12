package org.scoula.icecream.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.icecream.dto.IcecreamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class IcecreamServiceImplTest {


    @Autowired
    private IcecreamService service;

    @Test
    void create() {
        IcecreamDTO icecream=new IcecreamDTO();
        icecream.setName("새로운 아이스크림");
        icecream.setFlavor("새로운 맛");
        icecream.setPrice(5000L);

        service.create(icecream);

        log.info(icecream.getNo());
    }
}