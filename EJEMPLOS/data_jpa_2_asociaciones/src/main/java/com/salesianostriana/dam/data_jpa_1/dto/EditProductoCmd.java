package com.salesianostriana.dam.data_jpa_1.dto;

import com.salesianostriana.dam.data_jpa_1.models.Category;

public record EditProductoCmd(
        String nombre,
        String descripcion,
        double precio,
        Long categoriaId
) {

}
