package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.service.RescueCenter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            context.getBean(RescueCenter.class);  // 또는 context.getBean(RescueCenter.class);
        }
    }
}
