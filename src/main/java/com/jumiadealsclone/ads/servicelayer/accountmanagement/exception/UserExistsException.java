package com.jumiadealsclone.ads.servicelayer.accountmanagement.exception;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String message) {
        super(message);
    }
}
