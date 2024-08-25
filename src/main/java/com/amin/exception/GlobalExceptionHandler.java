package com.amin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        String message = notFoundException.getMessage() != null ? notFoundException.getMessage() : "OBJECT_NOT_FOUND_EXCEPTION";
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(message);
    }
}
