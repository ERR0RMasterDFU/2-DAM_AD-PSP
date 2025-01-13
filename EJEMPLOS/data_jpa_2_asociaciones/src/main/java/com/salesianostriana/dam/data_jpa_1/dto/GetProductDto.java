package com.salesianostriana.dam.data_jpa_1.dto;

import com.salesianostriana.dam.data_jpa_1.models.Product;

public record GetProductDto(
        Long id,
        String nombre,
        double precio,
        GetCategoryDto categoria
) {

    public static GetProductDto of(Product p) {
        return new GetProductDto(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                GetCategoryDto.of(p.getCategoria())
        );
    }

}
