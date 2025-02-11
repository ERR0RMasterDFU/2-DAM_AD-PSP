package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumno {
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    private Direccion direccion;
    private Curso curso;
}
