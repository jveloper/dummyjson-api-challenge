package dev.jveloper.thortfulcodechallenge.response;

import lombok.Data;

import java.util.List;

@Data
public class CartResponse {

   private Integer id;
   private Double discountedTotal;
   private Integer userId;
   private Integer totalProducts;
   private Double total;


}
