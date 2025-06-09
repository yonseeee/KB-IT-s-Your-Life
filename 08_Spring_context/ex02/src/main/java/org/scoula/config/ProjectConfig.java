package org.scoula.config;


import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot (){
        Parrot p=new Parrot ();
        p.setName("koko");
        return p;
    }

    @Bean
    public Person person(){
        Person p=new Person();
        p.setName("Ella");
//        Parrot을 설정하는 방법
//        1.직접 메소드 호출
//        2.매개변수로 넘겨받기
        p.setParrot(parrot ());
        return p;
    }

    @Bean
    public Person person(Parrot parrot){
        Person p=new Person();
        p.setName("Ella");
        p.setParrot(parrot);
        return p;
    }
}
