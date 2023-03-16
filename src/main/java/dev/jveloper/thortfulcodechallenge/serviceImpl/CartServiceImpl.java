package dev.jveloper.thortfulcodechallenge.serviceImpl;

import dev.jveloper.thortfulcodechallenge.exception.ResourceNotFoundException;
import dev.jveloper.thortfulcodechallenge.helper.ResourcesURI;
import dev.jveloper.thortfulcodechallenge.response.CartListResponse;
import dev.jveloper.thortfulcodechallenge.response.CartResponse;
import dev.jveloper.thortfulcodechallenge.response.ProductListResponse;
import dev.jveloper.thortfulcodechallenge.response.ProductResponse;
import dev.jveloper.thortfulcodechallenge.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.http.HttpResponse;

@Service
public class CartServiceImpl implements CartService {

    private final WebClient webClient;

    public CartServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<CartResponse> getCart(Integer id) {

        return webClient.get()
                .uri(ResourcesURI.URI_CARTS + id)
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.NOT_FOUND.value(),
                        response -> Mono.error(new ResourceNotFoundException(id)))
                .bodyToMono(CartResponse.class);

    }

    @Override
    public Flux<CartListResponse> getCarts() {

        return webClient.get()
                .uri(ResourcesURI.URI_USERS)
                .retrieve()
                .bodyToFlux(CartListResponse.class)
                .log();
    }
}
