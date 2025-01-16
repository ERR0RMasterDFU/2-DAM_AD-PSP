package com.example.ejercicio02_asociaciones;

import com.example.ejercicio02_asociaciones.repositories.CursoOnlineRepository;
import com.example.ejercicio02_asociaciones.repositories.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class mainDeMentira {

    private final ProfesorRepository profeRepo;
    private final CursoOnlineRepository cursoRepo;

    @PostConstruct
    public void init () {

    }
}
