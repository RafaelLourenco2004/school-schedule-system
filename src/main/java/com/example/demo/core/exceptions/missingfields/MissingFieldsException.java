package com.example.demo.core.exceptions.missingfields;

public class MissingFieldsException extends RuntimeException {

    private String message;

    public MissingFieldsException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }
}
