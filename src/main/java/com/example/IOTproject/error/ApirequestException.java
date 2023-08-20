package com.example.IOTproject.error;

public class ApirequestException extends RuntimeException{
    public ApirequestException() {
        super();
    }

    public ApirequestException(String message) {
        super(message);
    }
}
