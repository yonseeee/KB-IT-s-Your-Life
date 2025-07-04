package org.scoula.config;

import org.scoula.security.config.SecurityConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    final String LOCATION = "c:/upload";
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L;//10M (파일 하나의 최대 크기)
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L;//20M ()
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;//5M보다 작은 녀석을 핸들링할 때는 메모리 사용

    //루트 어플리케이션 설정(서비스, DAO, DB 등)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, SecurityConfig.class};
    }

//    서블릿 어플리케이션 설정 (Controller, ViewResolver 등)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class, SwaggerConfig.class};
    }

//    DispatcherServlet의 URL 매핑
    @Override
    protected String[] getServletMappings() {
//        모든 요청을 DispatcherServlet이 처리
        return new String[]{"/"};
    }

//    한글 POST 요청 인코딩 필터 설정
//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        return new Filter[]{characterEncodingFilter};
//
//    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        존재하지 않는 URL 요청 시 404 응답이 아닌 예외 발생시킴
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION, // 업로드처리디렉토리경로
                MAX_FILE_SIZE, // 업로드가능한파일하나의최대크기
                MAX_REQUEST_SIZE, //업로드가능한전체최대크기(여러파일업로드하는경우)
                FILE_SIZE_THRESHOLD // 메모리파일의최대크기(이보다작으면실제메모리에서만작업)
        );
        registration.setMultipartConfig(multipartConfig);
    }
}
