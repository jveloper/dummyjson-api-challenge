package dev.jveloper.thortfulcodechallenge.serviceImpl;

import dev.jveloper.thortfulcodechallenge.exception.ResourceNotFoundException;
import dev.jveloper.thortfulcodechallenge.response.UserListResponse;
import dev.jveloper.thortfulcodechallenge.response.UserResponse;
import dev.jveloper.thortfulcodechallenge.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final WebClient webClient;

    public UserServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<UserResponse> getUser(Integer id) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/users/{id}")
                        .build(id))
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.NOT_FOUND.value(),
                        response -> Mono.error(new ResourceNotFoundException(id)))
                .bodyToMono(UserResponse.class);

    }

    @Override
    public Flux<UserListResponse> getUsers() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/users")
                        .build())
                .retrieve()
                .bodyToFlux(UserListResponse.class)
                .log();
    }

}
