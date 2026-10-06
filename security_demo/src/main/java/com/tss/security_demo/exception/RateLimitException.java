package com.tss.security_demo.exception;

import org.springframework.http.HttpStatus;

public class RateLimitException extends RuntimeException {

    private final HttpStatus httpStatus;

    public RateLimitException(String message)
    {
        super(message);
        this.httpStatus = HttpStatus.TOO_MANY_REQUESTS;
    }

    public HttpStatus getStatus()
    {
        return httpStatus;
    }
}
