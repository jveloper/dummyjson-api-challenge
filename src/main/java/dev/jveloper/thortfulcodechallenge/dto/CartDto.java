package dev.jveloper.thortfulcodechallenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {

    private Integer id;
    private Double discountedTotal;
    private Integer userId;
    private Integer totalProducts;
    private Double total;

}
