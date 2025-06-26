package org.scoula.security.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity//Spring Security 활성화
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    DB 기반 인증 처리를 위한 서비스(in-memory방식과 병행 x)
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationErrorFilter authenticationErrorFilter;
    @Autowired
    private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;

    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Bean//다른 곳에서 쓰이므로 빈 등록
    public PasswordEncoder passwordEncoder() {
//        보안 강화를 위한 BCrypt 해시 알고리즘 사용
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {//로그인 성공 시 응답 실패 시 응답을 담당
        return super.authenticationManager();
    }


//    Cors
    @Bean
    public CorsFilter corsFilter() {//자동으로 적용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);//인증 정보 포함 허용
        config.addAllowedOriginPattern("*");//모든 oRIGIN 허용
        config.addAllowedHeader("*");//모든 헤더 허용
        config.addAllowedMethod("*");//모든 HTTP Method 허용
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

//    정적 리소스 및 인증 제외 경로 설정
    @Override
    public void configure(WebSecurity web) throws Exception {//보안체크하지 마라
        web.ignoring().antMatchers("/assets/**", //정적 리소스
                "/*", //루트 경로
                "/api/member/**",// 회원가입 등 비인증 API

//                Swagger 관련 리소스
                "/swagger-ui.html","/webjars/**","/swagger-resources/**","/v2/api-docs"
        );
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(encodingFilter(), CsrfFilter.class)
                .addFilterBefore(authenticationErrorFilter,UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling()
                        .authenticationEntryPoint(authenticationEntryPoint)
                                .accessDeniedHandler(accessDeniedHandler);

        http
                .authorizeRequests()
                        .antMatchers(HttpMethod.OPTIONS).permitAll()
                        .anyRequest().permitAll();

        http
                .httpBasic().disable()//기본 HTTP 인증 비활성화
                .csrf().disable()//CSRF 보호 비활성화
                .formLogin().disable()//폼 로그인 기능 비활성화
                .sessionManagement().
                sessionCreationPolicy(SessionCreationPolicy.STATELESS);//세션 사용 안함(JWT 기반 인증 대응)
    }

//인증 매니저 구성: 사용자 정보와 패스워드 인코더 설정
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        DB에서 사용자 정보를 조회하고, 해시된 비밀번호를
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }




}
