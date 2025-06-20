package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect//AOP 기능 정의 클래스
@Log4j2
@Component
public class LogAdvice {

//    SampleService의 모든 메서드 실행 전에 로그 출력
    @Before("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public void logBefore(){
        log.info("=================");
    }

//    args: 메서드 인자값을 Advice 메서드에 매핑하여 전달
    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String,String))&&args(str1,str2)")
    public void logBeforeWithParam(String str1, String str2){
        log.info("str1:"+str1);
        log.info("str2:"+str2);
    }

    @AfterThrowing(pointcut="execution(* org.scoula.sample.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception){
        log.info("Exception...!!!!");
        log.info("exception: "+exception);
    }

    @Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp){
        long start=System.currentTimeMillis();

        log.info("Target "+pjp.getTarget());
        log.info("Param: "+ Arrays.toString(pjp.getArgs()));

        Object result=null;
        try{
            result=pjp.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }

        long end=System.currentTimeMillis();
        log.info("TIME: "+(end-start));

        return result;
    }
}
