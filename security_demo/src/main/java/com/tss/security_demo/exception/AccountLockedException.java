package com.tss.security_demo.exception;

public class AccountLockedException extends RuntimeException{

    public AccountLockedException(String message) {
        super(message);
    }
}
