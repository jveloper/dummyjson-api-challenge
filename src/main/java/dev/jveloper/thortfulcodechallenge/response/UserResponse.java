package dev.jveloper.thortfulcodechallenge.response;

import lombok.Data;

import java.sql.Date;

@Data
public class UserResponse {

    private String firstName;
    private String LastName;
    private Integer age;
    private Date birthDate;

}
