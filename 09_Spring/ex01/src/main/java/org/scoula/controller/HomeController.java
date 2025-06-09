package org.scoula.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HomeController {

    @GetMapping("/") // "/"요청이 오면 home 메소드 호출
    public String home(){
        log.info("========");
        return "index";//view의 이름   접두어+index+접미어=>jsp경로 설정
    }
}
