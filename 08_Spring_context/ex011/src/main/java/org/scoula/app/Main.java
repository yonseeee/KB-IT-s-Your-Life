package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p=context.getBean(Parrot.class);
        System.out.println(p.getName());

        Parrot p2=context.getBean(Parrot.class);
        System.out.println(p2.getName());

        System.out.println(p==p2);
    }
}
