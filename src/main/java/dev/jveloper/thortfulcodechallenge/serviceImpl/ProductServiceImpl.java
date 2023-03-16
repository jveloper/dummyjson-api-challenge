package dev.jveloper.thortfulcodechallenge.serviceImpl;

import dev.jveloper.thortfulcodechallenge.exception.ResourceNotFoundException;
import dev.jveloper.thortfulcodechallenge.helper.ResourcesURI;
import dev.jveloper.thortfulcodechallenge.response.ProductListResponse;
import dev.jveloper.thortfulcodechallenge.response.ProductResponse;
import dev.jveloper.thortfulcodechallenge.response.UserListResponse;
import dev.jveloper.thortfulcodechallenge.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private final WebClient webClient;

    public ProductServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<ProductResponse> getProduct(Integer id) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/products/{id}")
                        .build(id))
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.NOT_FOUND.value(),
                        response -> Mono.error(new ResourceNotFoundException(id)))
                .bodyToMono(ProductResponse.class);

    }

    @Override
    public Flux<ProductListResponse> getProducts() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/products")
                        .build())
                .retrieve()
                .bodyToFlux(ProductListResponse.class)
                .log();

    }




}
