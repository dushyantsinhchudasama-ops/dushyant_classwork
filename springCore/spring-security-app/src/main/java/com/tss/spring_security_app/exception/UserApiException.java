package com.tss.spring_security_app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserApiException extends RuntimeException {

    private final HttpStatus status;

    public UserApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}