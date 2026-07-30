package com.tss.__jpa.exception;

import com.tss.__jpa.error.Error;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.apache.coyote.Response;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //this method will be used for handlind the exceptions
    @ExceptionHandler(StudentNotFoundByIDException.class)
    public ResponseEntity<com.tss.__jpa.error.Error> handleStudentNotFoundByIDException(StudentNotFoundByIDException exception, HttpServletRequest request) {
        com.tss.__jpa.error.Error error = new Error(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //for handling employeenotfoundbyidexception
    @ExceptionHandler(EmployeeNotFoundByIDException.class)
    public ResponseEntity<Error> handlseEmployeeNotFoundException(EmployeeNotFoundByIDException exception, HttpServletRequest request) {
        Error error = new Error(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //method for handling exception for validations
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        builder.append(error.getField())
                                .append(" : ")
                                .append(error.getDefaultMessage())
                                .append(", "));

        Error error = new Error(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                builder.toString(),
                request.getRequestURI());

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }

    //validate the field for added in feild
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Error> handleMethodValidation(
            ConstraintViolationException ex,
            HttpServletRequest request) {

        Error error = new Error(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //validation for the address
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<Error> hanldeAddressNotfoundValidation(
            AddressNotFoundException ex,
            HttpServletRequest request) {

        Error error = new Error(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //validation for the address
    @ExceptionHandler(AddressAlreadyExistsException.class)
    public ResponseEntity<Error> hanldeAddressAlreadyExistValidation(
            AddressAlreadyExistsException ex,
            HttpServletRequest request) {

        Error error = new Error(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
