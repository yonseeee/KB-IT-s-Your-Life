package org.scoula.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

//에러가 발생했을 때 forwarding 돼서 넘어옴
@ControllerAdvice// 모든 컨트롤러에서 발생하는 예외 처리
@Log4j2
public class CommonExceptionAdvice {

    @ExceptionHandler(Exception.class)//Exception(모든 예외)을 처리하겠다
    public String except(Exception ex, Model model){
        log.error(("Exception......"+ex.getMessage()));
//        Model로 예외 객체를 뷰에 전달
        model.addAttribute("exception", ex);
        log.error(model);
        return "error_page";//뷰 이름
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model model, HttpServletRequest request){
        log.error(ex);
//        어떤 경로에서 404가 발생했는지 뷰에 전달
        model.addAttribute("uri", request.getRequestURI());
        return "custom404";
    }
}
