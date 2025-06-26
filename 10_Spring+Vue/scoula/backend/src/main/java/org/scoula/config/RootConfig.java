package org.scoula.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@PropertySource({"classpath:/application.properties"})//설정 파일 위치 지정
@MapperScan(basePackages = {"org.scoula.board.mapper"})//Mapper 인터페이스 검색용
@ComponentScan(basePackages = {"org.scoula.board.service"})
@Log4j2
@EnableTransactionManagement
public class RootConfig {
    @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Autowired
    ApplicationContext applicationContext;//이미 dispatacherServlet에 의해서 bean으로 등록되어 있어서 주입 가능

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        MyBatis 설정 파일(xml) 위치 지정
        sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));//클래스패스의 경로를 파악하기 위해 applicationContext가 필요
//        커넥션 풀
        sqlSessionFactory.setDataSource(dataSource());//실행은 딱 한 번 실행

        return(SqlSessionFactory)sqlSessionFactory.getObject();
    }

//    트랜잭션 매니저 등록
    @Bean
    public DataSourceTransactionManager transactionManager() {
        //proxy의 datasource를 호출
//        DataSource 기반 트랜잭션 매니저 생성
        return new DataSourceTransactionManager(dataSource());
    }
}
