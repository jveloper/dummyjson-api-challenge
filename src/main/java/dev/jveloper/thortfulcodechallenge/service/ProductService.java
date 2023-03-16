package dev.jveloper.thortfulcodechallenge.service;

import dev.jveloper.thortfulcodechallenge.response.ProductListResponse;
import dev.jveloper.thortfulcodechallenge.response.ProductResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ProductService {

    Mono<ProductResponse> getProduct(Integer id);
    Flux<ProductListResponse> getProducts();

}
