package org.scoula.security.filter;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    private final JwtProcessor jwtProcessor;
    private final UserDetailsService userDetailsService;


    private Authentication getAuthentication(String token) {//매개변수: jwt
        String username=jwtProcessor.getUsername(token);// JWT에서 사용자 이름 추출
        UserDetails principal=userDetailsService.loadUserByUsername(username);//UserDetails로드

//        UserDetails 정보로 Authentication 객체 생성
        return new UsernamePasswordAuthenticationToken(principal,null,principal.getAuthorities());
    }

//    실제 필터 동작 수행
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//       HTTP 헤더에서 토큰 추출 (Bearer xxx.xxx.xxxx)
        String bearerToken=request.getHeader(AUTHORIZATION_HEADER);//null이면 로그인 안 한 사용자->Annonymous

        if(bearerToken!=null&&bearerToken.startsWith(BEARER_PREFIX)){//첫번째 조건: 존재여부 없으면 null, 두번째 조건: 기본형식 체크
//          "Bearer "부분을 제외하고 토큰 값만 잘라내기
            String token=bearerToken.substring(BEARER_PREFIX.length());


//            토큰으로부터 Authentication 생성 후  SecurityContext에 저장
            Authentication authentication=getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        super.doFilter(request, response, filterChain);
    }
}
