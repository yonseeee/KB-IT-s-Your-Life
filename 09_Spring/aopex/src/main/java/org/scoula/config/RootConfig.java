package org.scoula.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
        "org.scoula.advice",
        "org.scoula.sample.service"
})
@EnableAspectJAutoProxy//AspectJ 기반 AOP 자동 프록시 생성 활성화
public class RootConfig {

}
