package dev.jveloper.thortfulcodechallenge.configs;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
@Log
public class WebClientConfig {

    @Bean
    WebClient webClient(){

        return WebClient.builder()
                .baseUrl("https://dummyjson.com/")
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true).wiretap(true)))
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
