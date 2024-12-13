package com.salesianostriana.dam.api_rest_01.dto;

import com.salesianostriana.dam.api_rest_01.models.Product;

import java.util.List;

public record createProductDto (
        String name,
        double price
) {

    public static GetProductListDto of(List<Product> items) {
        return new GetProductListDto((long) items.size(), items);
    }

    public Product to() {
        return new Product(null, this.name, this.price);
    }

}