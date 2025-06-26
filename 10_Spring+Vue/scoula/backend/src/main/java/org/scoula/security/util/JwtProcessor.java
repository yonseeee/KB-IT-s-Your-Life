package org.scoula.security.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
    static private final long TOKEN_VALID_MILISECOND=1000L*60*5;

    private String secretKey="this_is_32_byte_secret_key!!!!!!!!!!!!!!!";
    private Key key= Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
// 운영 시 사용
    //    private Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);


//    JWT 토큰 생성
    public String generateToken(String subject){
        return Jwts.builder()
                .setSubject(subject)//사용자 정보(주체)
                .setIssuedAt(new Date())//발급 시간
                .setExpiration(new Date(new Date().getTime()+TOKEN_VALID_MILISECOND))//민료 시간
                .signWith(key)//서명용 키로 서명
                .compact();//최종 토큰 문자열 생성
    }

//    토큰에서 사용자 이름(subject) 추출
    public String getUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

//    토큰 유효성 검증(형식 및 만료 여부 확인)
    public boolean validateToken(String token){//refresh token 검증시
        Jws<Claims> claims=Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;//여기까지 왔으면 유효한 토큰
    }
}
