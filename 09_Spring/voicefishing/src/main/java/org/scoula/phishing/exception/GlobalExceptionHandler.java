package org.scoula.phishing.exception;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    @ExceptionHandler(PhishingDetectedException.class)
    public ResponseEntity<String> handlePhishingDetected(PhishingDetectedException e) {
        log.info("phishing detected");

        return ResponseEntity
                .badRequest()
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(e.getMessage());
    }
}
