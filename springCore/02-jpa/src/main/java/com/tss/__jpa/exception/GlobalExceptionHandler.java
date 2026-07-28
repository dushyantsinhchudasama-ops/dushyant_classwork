package com.tss.__jpa.exception;

import com.tss.__jpa.error.Error;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    //this method will be used for handlind the exceptions
    @ExceptionHandler(StudentNotFoundByIDException.class)
    public ResponseEntity<com.tss.__jpa.error.Error> handleStudentNotFoundByIDException(StudentNotFoundByIDException exception, HttpServletRequest request)
    {
        com.tss.__jpa.error.Error error = new Error(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //for handling employeenotfoundbyidexception
    @ExceptionHandler(EmployeeNotFoundByIDException.class)
    public ResponseEntity<Error> handlseEmployeeNotFoundException(EmployeeNotFoundByIDException exception, HttpServletRequest request)
    {
        Error error = new Error(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
