package dev.jveloper.thortfulcodechallenge.response;

import lombok.Data;

@Data
public class ProductResponse {

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private Integer stock;

}
