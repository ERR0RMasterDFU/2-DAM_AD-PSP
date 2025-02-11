package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    private Long id;
    private String nombre;
    private String desc;
    private double pvp;
    private List<String> imagenes;
    private Categoria categoria;
}
