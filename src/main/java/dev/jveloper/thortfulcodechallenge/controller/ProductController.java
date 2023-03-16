package dev.jveloper.thortfulcodechallenge.controller;

import dev.jveloper.thortfulcodechallenge.dto.ProductDto;
import dev.jveloper.thortfulcodechallenge.serviceImpl.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;


    public ProductController(ProductServiceImpl productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<ProductDto>> retrieveProductById(@PathVariable("id") String id){
        return ResponseEntity.ok(productService.getProduct(Integer.parseInt(id)).map(v -> modelMapper.map(v, ProductDto.class)));

    }

    @GetMapping
    public ResponseEntity<Flux<ProductDto>> retrieveProducts(@RequestParam(name = "minStock", required = false) Integer minQuantityStock){

        Optional<Integer> optMinQty = Optional.ofNullable(minQuantityStock);

        if (optMinQty.isPresent()){
            return ResponseEntity.ok(productService.getProducts().map(v -> modelMapper.map(v, ProductDto.class)));
        }
        else {
            return ResponseEntity.ok(productService.getProductsByMinStock(minQuantityStock).map(v -> modelMapper.map(v, ProductDto.class)));
        }

    }



}
