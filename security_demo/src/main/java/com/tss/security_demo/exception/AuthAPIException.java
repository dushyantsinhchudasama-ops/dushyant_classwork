package com.tss.security_demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@Getter
public class AuthAPIException extends RuntimeException {

    private final HttpStatus status;

    public AuthAPIException(String message, HttpStatus status)
    {
        super(message);
        this.status = status;
    }

}
