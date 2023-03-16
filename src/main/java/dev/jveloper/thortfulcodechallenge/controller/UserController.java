package dev.jveloper.thortfulcodechallenge.controller;

import dev.jveloper.thortfulcodechallenge.dto.UserDto;
import dev.jveloper.thortfulcodechallenge.dto.UserListDto;
import dev.jveloper.thortfulcodechallenge.response.UserListResponse;
import dev.jveloper.thortfulcodechallenge.serviceImpl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/users/")
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;


    public UserController(UserServiceImpl userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Mono<UserListDto>> retrieveUsers(){
        return ResponseEntity.ok(userService.getUsers().map(v -> modelMapper.map(v, UserListDto.class)));

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<UserDto>> retrieveUserById(@PathVariable("id") String userId){
        return ResponseEntity.ok(userService.getUser(Integer.parseInt(userId)).map(v -> modelMapper.map(v, UserDto.class)));

    }


}
