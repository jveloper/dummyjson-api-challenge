package dev.jveloper.thortfulcodechallenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDto {

    private String firstName;
    private String LastName;
    private Integer age;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp birthDate;

}
