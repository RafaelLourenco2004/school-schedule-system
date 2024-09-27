package com.example.demo.core.exceptions;

public class MissingFieldsException extends RuntimeException {

    private String message;

    public MissingFieldsException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
