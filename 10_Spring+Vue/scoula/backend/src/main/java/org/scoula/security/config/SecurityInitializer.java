package org.scoula.security.config;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

//보안 필터 등록하는 클래스 상속
//상속만 받으면 자동으로 됨
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {//security filter의 연결 순서 조정
    private CharacterEncodingFilter encodingFilter(){
        CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        return encodingFilter;
    }

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        insertFilters(servletContext, encodingFilter(), new MultipartFilter());
    }
}
