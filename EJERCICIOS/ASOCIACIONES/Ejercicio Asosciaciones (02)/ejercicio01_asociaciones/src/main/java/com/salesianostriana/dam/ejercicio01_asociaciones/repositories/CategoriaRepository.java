package com.salesianostriana.dam.ejercicio01_asociaciones.repositories;

import com.salesianostriana.dam.ejercicio01_asociaciones.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
