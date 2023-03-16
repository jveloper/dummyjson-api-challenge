package dev.jveloper.thortfulcodechallenge.controller;

import dev.jveloper.thortfulcodechallenge.dto.UserDto;
import dev.jveloper.thortfulcodechallenge.dto.UserListDto;
import dev.jveloper.thortfulcodechallenge.response.CartListResponse;
import dev.jveloper.thortfulcodechallenge.response.CartResponse;
import dev.jveloper.thortfulcodechallenge.serviceImpl.CartServiceImpl;
import dev.jveloper.thortfulcodechallenge.serviceImpl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/carts/")
public class CartController {

    private final CartServiceImpl cartService;
    private final ModelMapper modelMapper;


    public CartController(CartServiceImpl cartService, ModelMapper modelMapper) {
        this.cartService = cartService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Flux<CartListResponse>> retrieveCarts(){

        return ResponseEntity.ok(cartService.getCarts().map(v -> modelMapper.map(v, CartListResponse.class)));

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<CartResponse>> retrieveCartById(@PathVariable("id") String userId){

        return ResponseEntity.ok(cartService.getCart(Integer.parseInt(userId)).map(v -> modelMapper.map(v, CartResponse.class)));

    }


}
