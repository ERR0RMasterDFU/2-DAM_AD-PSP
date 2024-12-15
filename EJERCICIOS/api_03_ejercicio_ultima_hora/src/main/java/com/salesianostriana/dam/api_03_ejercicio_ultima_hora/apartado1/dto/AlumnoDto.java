package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1.dto;

import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1.models.Alumno;

public record AlumnoDto(
    String nombre,
    String apellidos,
    String email,
    String curso,
    String direccion
){

    public static AlumnoDto toAlumnoDto(Alumno a) {
        String apellidos = a.getApellido1() + " " + a.getApellido2();
        String curso = a.getCurso().getNombre() + " de " + a.getCurso().getTipo();
        String direccion = a.getDireccion().getTipoVia() + " " +
                a.getDireccion().getLinea1() + ", " + a.getDireccion().getLinea2();

        return new AlumnoDto(
            a.getNombre(),
            apellidos,
            a.getEmail(),
            curso,
            direccion
        );
    }

}