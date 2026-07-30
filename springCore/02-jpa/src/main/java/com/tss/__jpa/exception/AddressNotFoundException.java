package com.tss.__jpa.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class AddressNotFoundException extends RuntimeException{

    private Long id;

    public String getMessage()
    {
        return "Address not found with ID : " + id;
    }

}
