package com.example.ejercicio02_asociaciones.models;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoPk implements Serializable {
    private Long id;
    private CursoOnline cursoOnline;
}
