package com.example.practica_1.repositories;

import com.example.practica_1.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
