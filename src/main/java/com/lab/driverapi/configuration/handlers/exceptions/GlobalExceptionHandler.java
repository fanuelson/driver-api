package com.lab.driverapi.configuration.handlers.exceptions;


import com.lab.driverapi.exceptions.ApiException;
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

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<String> handleInternalServerException2(final ApiException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<String> handleNoResourceFoundException(final NoResourceFoundException ex) {
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

}
