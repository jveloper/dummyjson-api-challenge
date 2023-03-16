package dev.jveloper.thortfulcodechallenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartListDto {

    private List<CartDto> products;
    private Integer limit;

}
