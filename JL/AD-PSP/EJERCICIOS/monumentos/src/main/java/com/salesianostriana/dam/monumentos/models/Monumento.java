package com.salesianostriana.dam.monumentos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false) //DICHO ATRIBUTO NO PUEDE SER NULO
    private String nombrePais;

    @Column(nullable = false)
    private String nombreCiudad;

    @Column(nullable = false)
    private String latitud;

    @Column(nullable = false)
    private String longitud;

    @Column(nullable = false)
    private String nombreMonumento;

    @Lob
    @Column(nullable = false)
    private String descripcion;

    @Lob
    @Column(nullable = false)
    private String foto;
}
