package dev.jveloper.thortfulcodechallenge.service;

import dev.jveloper.thortfulcodechallenge.response.CartListResponse;
import dev.jveloper.thortfulcodechallenge.response.CartResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CartService {

    Mono<CartResponse> getCart(Integer id);
    Flux<CartListResponse> getCarts();

}
