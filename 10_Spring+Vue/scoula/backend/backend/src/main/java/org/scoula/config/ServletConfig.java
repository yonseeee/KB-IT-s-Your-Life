package org.scoula.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc //Spring MVC 기능 활성화
@ComponentScan(basePackages = {"org.scoula.controller", "org.scoula.exception","org.scoula.board.controller"})
public class ServletConfig implements WebMvcConfigurer {

    //    정적 자원 처리 설정(CSS, JS, 이미지 등)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**") //요청 URL 경로, (여기서 요청 들어오면)
                .addResourceLocations("/resources/");//실제 리소스 위치, (여기서 처리한다)

        registry
                .addResourceHandler("/assets/**")
                .addResourceLocations("/resources/assets/");

        // Swagger UI 리소스를 위한 핸들러 설정
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        // Swagger WebJar 리소스 설정
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // Swagger 리소스 설정
        registry.addResourceHandler("/swagger-resources/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/v2/api-docs").addResourceLocations("classpath:/META-INF/resources/");
    }

    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {//controlelr없이 포워딩 해주는 메소드
        registry.addViewController("/")//요청 url
                .setViewName("forward:/resources/index.html");
    }
}
