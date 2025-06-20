package org.scoula.phishing.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class PhishingDetectedException extends RuntimeException{

    public PhishingDetectedException(String message) {
        super(message);
    }
}
