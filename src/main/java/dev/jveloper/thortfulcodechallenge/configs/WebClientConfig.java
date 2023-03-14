package dev.jveloper.thortfulcodechallenge.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    WebClient webClient(){

        return WebClient.builder()
                .baseUrl("https://randomuser.me/api/")
                .build();
    }

}
