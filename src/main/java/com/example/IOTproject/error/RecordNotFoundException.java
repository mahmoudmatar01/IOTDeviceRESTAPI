package com.example.IOTproject.error;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super(message); // pass this message to RuntimeException class
    }
}
