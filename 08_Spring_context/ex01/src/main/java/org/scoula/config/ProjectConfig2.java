package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProjectConfig2 {

    @Bean
    Parrot parrot1(){
        var p=new Parrot();
        p.setName("koko");
        return p;
    }

    @Bean(name="miki")
    Parrot parrot2(){
        var p=new Parrot();
        p.setName("miki");
        return p;
    }


    @Bean
    Parrot parrot3(){
        var p=new Parrot();
        p.setName("riki");
        return p;
    }
}
