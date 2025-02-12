package com.lab.driverapi.configuration.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleInternalServerException(final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<String> handleInternalServerException2(final NoResourceFoundException ex) {
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
