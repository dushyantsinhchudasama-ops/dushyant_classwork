package com.tss.emp.service.employee_service.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignNotFound(FeignException ex) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid Department ID");
    }
}