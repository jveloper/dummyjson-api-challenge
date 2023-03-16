package dev.jveloper.thortfulcodechallenge.service;

import dev.jveloper.thortfulcodechallenge.response.UserListResponse;
import dev.jveloper.thortfulcodechallenge.response.UserResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface UserService {

    Mono<UserResponse> getUser(Integer id);
    Mono<UserListResponse> getUsers();

}
