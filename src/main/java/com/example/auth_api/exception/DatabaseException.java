package com.example.auth_api.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super("Error occur: " + message);
    }
}
