package dev.jveloper.thortfulcodechallenge.response;

import lombok.Data;

import java.util.List;

@Data
public class CartListResponse {

    private List<CartResponse> carts;
    private Integer limit;

}
