package dev.jveloper.thortfulcodechallenge.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ProductDto {

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private Integer stock;

}
