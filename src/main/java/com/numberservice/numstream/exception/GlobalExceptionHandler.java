package com.numberservice.numstream.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ HttpMessageNotReadableException.class })
    public ResponseEntity<String> handleInvalidInput(Exception ex) {
        return ResponseEntity.badRequest().body("Invalid input: must be a number");
    }
}
