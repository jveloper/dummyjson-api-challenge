package dev.jveloper.thortfulcodechallenge.response;

import lombok.Data;

import java.sql.Date;

@Data
public class UserResponse {

    private Integer id;
    private String firstName;
    private String LastName;
    private Integer age;
    private Date birthDate;

}
