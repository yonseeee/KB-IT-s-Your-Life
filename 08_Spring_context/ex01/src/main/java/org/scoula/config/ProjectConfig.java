package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Spring 설정 클래스 지정
public class ProjectConfig {

    @Bean //Spring 컨테이너에 빈으로 등록
    Parrot parrot(){
        var p=new Parrot();
        p.setName("Koko");
        return p;//Bean으로 등록할 객체 반환
    }

    @Bean
    String hello(){
        return "hello";
    }

    @Bean
    Integer ten(){
        return 10;
    }
}