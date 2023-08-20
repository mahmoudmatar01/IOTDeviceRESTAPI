package com.example.IOTproject.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handelRecordsNotFound(RecordNotFoundException ex){
        ErrorResponse error=new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<?> handelDuplicateRecordException(DuplicateRecordException ex){
        ErrorResponse error=new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }
    @ExceptionHandler(ApirequestException.class)
    public ResponseEntity<?> handelAPIrequestException(ApirequestException ex){
        ErrorResponse error=new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }
}
