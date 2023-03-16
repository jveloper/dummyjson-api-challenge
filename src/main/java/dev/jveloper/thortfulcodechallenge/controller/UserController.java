package dev.jveloper.thortfulcodechallenge.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.jveloper.thortfulcodechallenge.dto.UserDto;
import dev.jveloper.thortfulcodechallenge.dto.UserListDto;
import dev.jveloper.thortfulcodechallenge.response.UserListResponse;
import dev.jveloper.thortfulcodechallenge.serviceImpl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Flux<UserDto>> retrieveUsers(){
        return ResponseEntity.ok(userService.getUsers().map(v -> modelMapper.map(v, UserDto.class)));

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<UserDto>> retrieveUserById(@PathVariable("id") String userId){
        return ResponseEntity.ok(userService.getUser(Integer.parseInt(userId)).map(v -> modelMapper.map(v, UserDto.class)));

    }

    @PostMapping
    public ResponseEntity<Mono<UserDto>> saveUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto).map(v -> modelMapper.map(v, UserDto.class)));

    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Mono<UserDto>> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Integer userId) {
        return ResponseEntity.ok(userService.update(userDto, userId).map(v -> modelMapper.map(v, UserDto.class)));

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Mono<UserDto>> deleteUser(@PathVariable("id") Integer userId)  {
        return ResponseEntity.ok(userService.delete(userId).map(v -> modelMapper.map(v, UserDto.class)));

    }
}
