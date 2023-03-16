package dev.jveloper.thortfulcodechallenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class UserListDto {

    private List<UserDto> users;
    private Integer limit;

}
