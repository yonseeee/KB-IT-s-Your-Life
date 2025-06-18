package org.scoula.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final String API_NAME="Pokemon API";
    private final String API_VERSION="1.0";
    private final String API_DESCRIPTION="PokemonAPI를 이용한 실습 API";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                @RestController 가 붙은 클래스만 문서화 대상이 됨
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                모든 URL 경로를 포함
                .paths(PathSelectors.any())
                .build()
//                위에서 정의한 API 정보 반영
                .apiInfo(apiInfo());//api 기본 정보 구성
    }
}
