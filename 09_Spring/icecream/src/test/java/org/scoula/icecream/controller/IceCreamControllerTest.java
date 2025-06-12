package org.scoula.icecream.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


@Log4j2
@ExtendWith(SpringExtension.class)
@WebAppConfiguration//MockMvc 사용시 필요
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
class IceCreamControllerTest {

    @Autowired
    IceCreamController controller;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void create() throws Exception {
        String viewName = mockMvc.perform(MockMvcRequestBuilders.post("/icecream/new")
                        .param("name", "유니콘 젤리")
                        .param("flavor", "알록달록 젤리가 씹히는 무지개 맛")
                        .param("price", "5000"))
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info("viewName={}", viewName);
    }

}