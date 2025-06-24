package org.scoula.security.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class JwtProcessorTest {

    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {
        String username="user0";
        String token=jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }

    @Test
    void getUsername() {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDc0NTgyNCwiZXhwIjoxNzUwNzQ2MTI0fQ.R4ePIZ84OoxfbY8KrkE61jK7IVxJb5QUhMYTHtmkRow";

        String username=jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username);
    }

//    토큰 유효성 검사 테스트
    @Test
    void validateToken() {
//      발금 5분 이내에만 true, 그 이후엔 예외 발생
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDc0NTgyNCwiZXhwIjoxNzUwNzQ2MTI0fQ.R4ePIZ84OoxfbY8KrkE61jK7IVxJb5QUhMYTHtmkRow";
        boolean isValid=jwtProcessor.validateToken(token);
        log.info(isValid);
        assertTrue(isValid);//5분 지나면 예외 발생
    }
}