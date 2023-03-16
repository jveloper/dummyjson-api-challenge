package dev.jveloper.thortfulcodechallenge.configs;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@Log
public class WebClientConfig {

    @Bean
    WebClient webClient(){

        return WebClient.builder()
                .baseUrl("https://dummyjson.com/")
                .filter(logRequest())
                .build();
    }

    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info(String.valueOf(clientRequest.url()));
            return Mono.just(clientRequest);
        });
    }

}
