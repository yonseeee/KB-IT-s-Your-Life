package org.scoula.config;


import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot(){
        var p=new Parrot();
        p.setName("Koko");
        return p;
    }
}
