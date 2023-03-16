package dev.jveloper.thortfulcodechallenge.serviceImpl;
import dev.jveloper.thortfulcodechallenge.exception.ResourceNotFoundException;
import dev.jveloper.thortfulcodechallenge.helper.ResourcesURI;
import dev.jveloper.thortfulcodechallenge.response.CartListResponse;
import dev.jveloper.thortfulcodechallenge.response.CartResponse;
import dev.jveloper.thortfulcodechallenge.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CartServiceImpl implements CartService {

    private final WebClient webClient;

    public CartServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<CartResponse> getCartById(Integer id) {

        return webClient.get()
                .uri(ResourcesURI.URI_CARTS + id)
                .retrieve()
                .onStatus(status -> status.value() == HttpStatus.NOT_FOUND.value(),
                        response -> Mono.error(new ResourceNotFoundException(id)))
                .bodyToMono(CartResponse.class);

    }

    @Override
    public Mono<CartListResponse> getCarts() {

        return webClient.get()
                .uri(ResourcesURI.URI_CARTS)
                .retrieve()
                .bodyToMono(CartListResponse.class)
                .log();
    }

    @Override
    public Mono<CartListResponse> getCartsByUserId(Integer id) {

        return webClient.get()
                .uri(ResourcesURI.URI_CARTS + ResourcesURI.URI_NESTED_USER + id)
                .retrieve()
                .bodyToMono(CartListResponse.class)
                .log();
    }
}
