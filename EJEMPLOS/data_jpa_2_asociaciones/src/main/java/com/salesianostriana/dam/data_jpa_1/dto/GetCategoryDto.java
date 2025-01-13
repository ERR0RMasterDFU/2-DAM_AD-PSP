package com.salesianostriana.dam.data_jpa_1.dto;

import com.salesianostriana.dam.data_jpa_1.models.Category;

public record GetCategoryDto(Long id, String nombre) {

    public static GetCategoryDto of(Category categoria) {
        return new GetCategoryDto(categoria.getId(), categoria.getNombre());
    }

}