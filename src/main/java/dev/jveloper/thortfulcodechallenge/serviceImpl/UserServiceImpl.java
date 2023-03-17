package dev.jveloper.thortfulcodechallenge.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dev.jveloper.thortfulcodechallenge.dto.UserDto;
import dev.jveloper.thortfulcodechallenge.exception.ResourceNotFoundException;
import dev.jveloper.thortfulcodechallenge.helper.ResourcesURI;
import dev.jveloper.thortfulcodechallenge.response.UserListResponse;
import dev.jveloper.thortfulcodechallenge.response.UserResponse;
import dev.jveloper.thortfulcodechallenge.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final WebClient webClient;
    private final Gson gson;

    public UserServiceImpl(WebClient webClient, Gson gson) {
        this.webClient = webClient;
        this.gson = gson;
    }

    @Override
    public Mono<UserResponse> getUser(Integer id) {

        return webClient.get()
                .uri(ResourcesURI.URI_USERS + id)
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.NOT_FOUND.value(),
                        response -> Mono.error(new ResourceNotFoundException(id)))
                .bodyToMono(UserResponse.class)
                .log();

    }

    @Override
    public Flux<UserResponse> getUsers() {

        return webClient.get()
                .uri(ResourcesURI.URI_USERS_LIST)
                .retrieve()
                .bodyToMono(UserListResponse.class)
                .flatMapMany(v -> Flux.fromStream(v.getUsers().stream()))
                .log();
    }

    @Override
    public Mono<UserResponse> save(UserDto user) {

        return webClient.post()
                .uri(ResourcesURI.URI_ADD_USER)
                .body(BodyInserters.fromValue(user))
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.BAD_REQUEST.value(),
                        response -> Mono.error(new RuntimeException()))
                .bodyToMono(UserResponse.class);

    }

    @Override
    public Mono<UserResponse> update(UserDto user, Integer userId) {

        return webClient.put()
                .uri(ResourcesURI.URI_USERS + userId)
                .body(BodyInserters.fromValue(gson.toJson(user)))
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.BAD_REQUEST.value(),
                        response -> Mono.error(new RuntimeException()))
                .bodyToMono(UserResponse.class);

    }

    @Override
    public Mono<UserResponse> delete(Integer userId) {

        return webClient.delete()
                .uri(ResourcesURI.URI_USERS + userId)
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.BAD_REQUEST.value(),
                        response -> Mono.error(new RuntimeException()))
                .bodyToMono(UserResponse.class)
                .log();

    }
}
