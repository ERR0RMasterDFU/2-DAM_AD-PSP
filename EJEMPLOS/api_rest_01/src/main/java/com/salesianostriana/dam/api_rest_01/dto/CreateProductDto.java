package com.salesianostriana.dam.api_rest_01.dto;

import com.salesianostriana.dam.api_rest_01.models.Product;

import java.util.List;

public record CreateProductDto(
        String name,
        double price
) {

    public static GetProductListDto of(List<Product> items) {
        return new GetProductListDto((long) items.size(), items);
    }

    public Product toProduct() {
        return new Product(null, this.name, this.price);
    }
}