package com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class Vehiculo {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    private String marca;
    private String color;
    private String matricula;
    private double precio;

}
