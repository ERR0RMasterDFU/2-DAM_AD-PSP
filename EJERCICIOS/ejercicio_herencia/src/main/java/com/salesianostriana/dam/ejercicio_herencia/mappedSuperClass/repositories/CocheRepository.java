package com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.repositories;

import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.models.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepository extends JpaRepository<Coche, Long> {
}
