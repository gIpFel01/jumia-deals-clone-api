package com.jumiadealsclone.ads.servicelayer.categorymanagement.exception;

public class CategoryExistsException extends RuntimeException{
    public CategoryExistsException(String message) {
        super(message);
    }
}
