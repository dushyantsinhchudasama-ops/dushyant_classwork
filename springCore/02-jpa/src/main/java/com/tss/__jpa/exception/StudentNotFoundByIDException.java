package com.tss.__jpa.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentNotFoundByIDException extends RuntimeException{

    private Long id;

    public String getMessage()
    {
        return "Student not found with id :" + id;
    }

}
