package org.scoula.security.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity//Spring Security 활성화
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    DB 기반 인증 처리를 위한 서비스(in-memory방식과 병행 x)
    private final UserDetailsService userDetailsService;

    @Bean//다른 곳에서 쓰이므로 빈 등록
    public PasswordEncoder passwordEncoder() {
//        보안 강화를 위한 BCrypt 해시 알고리즘 사용
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

//        CSRF 필터보다 먼저 문자셋 필터 적용
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

//        경로별 접근 권한 설정
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll()//모든 사용자 접근 허용
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")//ADMIN 권한 보유자만 허용
                .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')");//MEMBER, ADMIN 권한 보유자 허용

        http.formLogin()//form 기반 로그인 설정 시작
                .loginPage("/security/login")//커스텀 로그인 페이지 (GET 요청)
                .loginProcessingUrl("/security/login")//로그인 요청 처리 경로 (POST 요청)
                .defaultSuccessUrl("/");//로그인 성공 시 리다이렉트될 기본 URL 설정

        http.logout()//로그아웃 설정 시작
                .logoutUrl("/security/logout")
                .invalidateHttpSession(true)
                .deleteCookies("remember-me", "JSESSION-ID")
                .logoutSuccessUrl("/security/logout");
    }

    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure..................");

//        DB에서 사용자 정보를 조회하고, 해시된 비밀번호를
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());


//        auth.inMemoryAuthentication()
//                .withUser("admin")
////                .password("{noop}1234")//평문 비밀번호(비권장)
//                .password("$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y")//암호화된 1234
//                .roles("ADMIN", "MEMBER");
//
//        auth.inMemoryAuthentication()
//                .withUser("member")
////                .password("{noop}1234")
//                .password("$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y")
//                .roles("MEMBER");
    }


}
