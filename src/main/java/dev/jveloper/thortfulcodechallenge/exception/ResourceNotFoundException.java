package dev.jveloper.thortfulcodechallenge.exception;

import java.sql.Timestamp;
import java.time.Instant;


public class ResourceNotFoundException extends RuntimeException {

    private final int resourceId;
    private static final String message = "Resource not Found";
    private final Timestamp timestamp;

    public ResourceNotFoundException(int id){
        super(message);
        this.resourceId = id;
        this.timestamp = Timestamp.from(Instant.now());
    }



}
