package com.salesianostriana.dam.api_rest_01.dto;

import com.salesianostriana.dam.api_rest_01.models.Product;

import java.util.List;

public record GetProductListDto (
    Long count,
    List<Product> items
) {

    public static GetProductListDto of(List<Product> items) {
        return new GetProductListDto((long) items.size(), items);
    }

    public List<Product> to() {
        return items;
    }

}
