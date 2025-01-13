package com.salesianostriana.dam.data_jpa_1.dto;

public record EditProductCmd(
        String nombre,
        String descripcion,
        double precio,
        Long categoriaId
) { }
