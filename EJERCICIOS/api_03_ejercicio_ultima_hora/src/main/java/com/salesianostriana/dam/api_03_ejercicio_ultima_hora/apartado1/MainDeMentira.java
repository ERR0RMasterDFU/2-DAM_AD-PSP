package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1;

import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1.dto.AlumnoDto;
import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1.models.Alumno;
import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1.models.Curso;
import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado1.models.Direccion;

import jakarta.annotation.PostConstruct;

public class MainDeMentira {

    @PostConstruct
    public void init() {

        Direccion direccion = Direccion.builder()
            .id(1L)
            .tipoVia("Calle")
            .linea1("Estrada Celeiros 57A")
            .linea2("10ºC")
            .cp(32786)
            .poblacion(104578)
            .provincia("Ourense")
        .build();

        Curso curso = Curso.builder()
            .id(1L)
            .nombre("Primero")
            .tipo("Bachillerato")
            .tutor("Luis Miguel López Magaña")
            .aula("303")
        .build();

        Alumno a = Alumno.builder()
            .id(1L)
            .nombre("Santiago")
            .apellido1("Carreta")
            .apellido2("Voinescu")
            .telefono("676002840")
            .email("carreton.huevero@gmail.com")
            .direccion(direccion)
            .curso(curso)
        .build();

        AlumnoDto alumno = AlumnoDto.toAlumnoDto(a);

    }

}
