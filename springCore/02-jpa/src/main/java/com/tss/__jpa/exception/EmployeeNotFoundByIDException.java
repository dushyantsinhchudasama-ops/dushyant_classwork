package com.tss.__jpa.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeNotFoundByIDException extends RuntimeException{

    private Long id;

    public String getMessage()
    {
        return "Employee not found with id: " + id;
    }
}
