package dev.jveloper.thortfulcodechallenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductListDto {

    private List<ProductDto> products;
    private Integer limit;

}
