package org.scoula.phishing.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.scoula.phishing.dto.MessageDTO;
import org.scoula.phishing.exception.PhishingDetectedException;
import org.springframework.stereotype.Component;

@Aspect//AOP 기능 정의 클래스
@Log4j2
@Component
public class LogAdvice {

    @Before("execution(* org.scoula.phishing.service.MessageService.sendMessage(..))&&args(dto)")
    public void logBefore(MessageDTO dto){
        log.info("[Before] 호출된 메서드: sendMessage");
        log.info("[Before] 전달된 파라미터: "+dto);
    }

//    함수 전후를 감사서 유연하게 처리해주는 Advice
    @Around("execution(* org.scoula.phishing.service.MessageService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp)  throws Throwable {
        long start=System.currentTimeMillis();

//        log.info("Target "+pjp.getTarget());
//        log.info("Param: "+ Arrays.toString(pjp.getArgs()));

        Object result=null;
        try{
            result=pjp.proceed();
        }catch(Throwable e){
            throw e;
        }

        long end=System.currentTimeMillis();
        log.info("⏱ [Around]: sendMessage 실행 시간: "+(end-start)+"ms");

        return result;
    }

    @AfterThrowing(pointcut="execution(* org.scoula.phishing.service.MessageService*.*(..))", throwing = "exception")
    public void logException(PhishingDetectedException exception){
        log.info("[After Throwing] 예외 발생: 보이스피싱 의심 단어 감지: "+exception.getMessage());
        log.info("대상 메서드: ");
    }
}
