package com.example.ejercicio02_asociaciones.repositories;

import com.example.ejercicio02_asociaciones.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
