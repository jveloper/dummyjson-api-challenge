package dev.jveloper.thortfulcodechallenge.controller;

import dev.jveloper.thortfulcodechallenge.dto.CartDto;
import dev.jveloper.thortfulcodechallenge.dto.CartListDto;
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
    public ResponseEntity<Mono<CartListDto>> retrieveCarts(){
        return ResponseEntity.ok(cartService.getCarts().map(c -> modelMapper.map(c, CartListDto.class)));

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<CartDto>> retrieveCartById(@PathVariable("id") String id){
        return ResponseEntity.ok(cartService.getCartById(Integer.parseInt(id)).map(c -> modelMapper.map(c, CartDto.class)));

    }

    @GetMapping("user/{id}")
    public ResponseEntity<Mono<CartListDto>> retrieveCartByUserId(@PathVariable("id") String userId){
        return ResponseEntity.ok(cartService.getCartsByUserId(Integer.parseInt(userId)).map(c -> modelMapper.map(c, CartListDto.class)));

    }


}
