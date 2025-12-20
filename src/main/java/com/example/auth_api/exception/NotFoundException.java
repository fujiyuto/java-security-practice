package com.example.auth_api.exception;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("Error occur: " + message);
    }
}
