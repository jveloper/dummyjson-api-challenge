package dev.jveloper.thortfulcodechallenge.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductListResponse {

    private List<ProductResponse> products;
    private Integer limit;


}
