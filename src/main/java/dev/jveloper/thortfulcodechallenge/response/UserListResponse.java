package dev.jveloper.thortfulcodechallenge.response;

import lombok.Data;

import java.util.List;

@Data
public class UserListResponse {

    private List<UserResponse> users;
    private Integer total;
    private Integer skip;
    private Integer limit;


}
