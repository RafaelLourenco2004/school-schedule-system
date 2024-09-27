package com.example.demo.core.exceptions;

public class BadRequestException extends RuntimeException{
    
    private String message;

    public String getMessage() {
        return message;
    }

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }
}
