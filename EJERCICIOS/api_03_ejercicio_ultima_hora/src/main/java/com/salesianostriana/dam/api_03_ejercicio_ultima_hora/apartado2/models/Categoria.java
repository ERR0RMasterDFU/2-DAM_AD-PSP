package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {
    private Long id;
    private String nombre;
}