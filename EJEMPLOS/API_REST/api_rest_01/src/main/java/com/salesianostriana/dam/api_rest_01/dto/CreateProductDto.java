package com.salesianostriana.dam.api_rest_01.dto;

import com.salesianostriana.dam.api_rest_01.models.Product;

public record CreateProductDto(
        String name,
        double price
) {

    public Product toProduct() {
        return new Product(null, this.name, this.price);
    }

}