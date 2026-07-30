package com.tss.__jpa.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressAlreadyExistsException extends RuntimeException{

    public String getMessage()
    {
        return "Address already exist for this student!";
    }
}
