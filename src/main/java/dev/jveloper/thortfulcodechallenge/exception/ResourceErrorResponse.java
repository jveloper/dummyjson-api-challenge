package dev.jveloper.thortfulcodechallenge.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResourceErrorResponse {

    private String message;
    private Timestamp timestamp;

}
