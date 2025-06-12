package org.scoula.icecream.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.icecream.domain.IcecreamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class IcecreamMapperTest {

    @Autowired
    private IcecreamMapper icecreamMapper;

    @Test
    void create() {
        IcecreamVO icecream=new IcecreamVO();

        icecream.setName("유니콘젤리");
        icecream.setFlavor("알록달록 젤리가 뽑히는 무지개 맛");
        icecream.setPrice(3900L);

        icecreamMapper.create(icecream);

        log.info(icecream);
    }
}