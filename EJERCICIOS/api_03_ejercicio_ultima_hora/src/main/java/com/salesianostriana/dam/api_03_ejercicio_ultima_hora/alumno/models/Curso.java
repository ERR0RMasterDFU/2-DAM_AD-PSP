package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.alumno.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso {
    private Long id;
    private String nombre;
    private String tipo;
    private String tutor;
    private String aula;
}
