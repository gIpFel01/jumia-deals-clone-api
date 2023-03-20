package com.jumiadealsclone.ads.servicelayer.localitymanagement.exception;

import com.jumiadealsclone.ads.servicelayer.accountmanagement.exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocalityExistsHandler {

    @ExceptionHandler(LocalityExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(LocalityExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }
}
