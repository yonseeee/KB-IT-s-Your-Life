package org.scoula.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc //Spring MVC 기능 활성화
@ComponentScan(basePackages = {"org.scoula.controller",
"org.scoula.ex03.controller","org.scoula.exception"})
public class ServletConfig implements WebMvcConfigurer {

//    정적 자원 처리 설정(CSS, JS, 이미지 등)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**") //요청 URL 경로, (여기서 요청 들어오면)
                .addResourceLocations("/resources/");//실제 리소스 위치, (여기서 처리한다)
    }

//    jsp view resolver 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean=new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);//JSTL 지원 뷰
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        registry.viewResolver(bean);//등록
    }

    @Bean
    public MultipartResolver multipartResolver(){
        StandardServletMultipartResolver resolver
                =new StandardServletMultipartResolver();
        return resolver;
    }
}
