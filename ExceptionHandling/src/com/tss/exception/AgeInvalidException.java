package com.tss.exception;

public class AgeInvalidException extends RuntimeException{

    private int age;

    public AgeInvalidException(int age) {
        this.age = age;
    }

    public String getMessage()
    {
        return "Age must be greater than 18. You entered: " + age;
    }

}
