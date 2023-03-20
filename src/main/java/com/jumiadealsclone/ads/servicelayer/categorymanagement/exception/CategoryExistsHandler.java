package com.jumiadealsclone.ads.servicelayer.categorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExistsHandler {

    @ExceptionHandler(CategoryExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(CategoryExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }
}
