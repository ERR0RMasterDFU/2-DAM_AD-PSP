package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2.dto;

import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2.models.Producto;

public record ProductoDto (
    String nombre,
    double pvp,
    String imagen,
    String categoria
){

    public static ProductoDto toProductoDto(Producto p) {
        return new ProductoDto(
            p.getNombre(),
            p.getPvp(),
            p.getImagenes().get(0),
            p.getCategoria().getNombre()
        );
    }

}
