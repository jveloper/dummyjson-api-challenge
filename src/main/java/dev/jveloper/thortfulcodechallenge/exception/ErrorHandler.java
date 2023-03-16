package dev.jveloper.thortfulcodechallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResourceErrorResponse> handleRuntimeException(Exception e){
        ResourceErrorResponse resourceErrorResponse = new ResourceErrorResponse(e.getMessage(), Timestamp.from(Instant.now()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(resourceErrorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceErrorResponse> handleResourceNotFoundException(RuntimeException e){
        ResourceErrorResponse resourceErrorResponse = new ResourceErrorResponse(e.getMessage(), Timestamp.from(Instant.now()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(resourceErrorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResourceErrorResponse> handleException(RuntimeException e){
        ResourceErrorResponse resourceErrorResponse = new ResourceErrorResponse(e.getMessage(), Timestamp.from(Instant.now()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(resourceErrorResponse);
    }
}
