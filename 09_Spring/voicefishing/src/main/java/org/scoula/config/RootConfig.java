package org.scoula.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
        "org.scoula.phishing.aop",
        "org.scoula.phishing.service"
})

@EnableAspectJAutoProxy
public class RootConfig {
}
