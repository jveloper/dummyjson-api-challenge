package dev.jveloper.thortfulcodechallenge.controller;

import dev.jveloper.thortfulcodechallenge.dto.ProductDto;
import dev.jveloper.thortfulcodechallenge.dto.ProductListDto;
import dev.jveloper.thortfulcodechallenge.dto.UserDto;
import dev.jveloper.thortfulcodechallenge.dto.UserListDto;
import dev.jveloper.thortfulcodechallenge.response.ProductListResponse;
import dev.jveloper.thortfulcodechallenge.serviceImpl.ProductServiceImpl;
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
@RequestMapping("v1/products/")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;


    public ProductController(ProductServiceImpl productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Mono<ProductListDto>> retrieveUsers(){
        return ResponseEntity.ok(productService.getProducts().map(v -> modelMapper.map(v, ProductListDto.class)));

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<ProductDto>> retrieveUserById(@PathVariable("id") String id){
        return ResponseEntity.ok(productService.getProduct(Integer.parseInt(id)).map(v -> modelMapper.map(v, ProductDto.class)));

    }


}
