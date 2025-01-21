package com.example.ejercicio02_asociaciones.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoPk implements Serializable {
    private Long id;
    private CursoOnline cursoOnline;
}
