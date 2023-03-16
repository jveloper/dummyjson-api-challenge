package dev.jveloper.thortfulcodechallenge.service;

import dev.jveloper.thortfulcodechallenge.dto.UserDto;
import dev.jveloper.thortfulcodechallenge.response.UserListResponse;
import dev.jveloper.thortfulcodechallenge.response.UserResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface UserService {

    Mono<UserResponse> getUser(Integer id);
    Flux<UserResponse> getUsers();
    Mono<UserResponse> save(UserDto user);
    Mono<UserResponse> update(UserDto userDto, Integer userId);

    Mono<UserResponse> delete(Integer userId);


}
