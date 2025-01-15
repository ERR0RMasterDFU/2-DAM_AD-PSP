package com.example.practica_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica_1.models.Alumno;
import org.springframework.stereotype.Repository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
