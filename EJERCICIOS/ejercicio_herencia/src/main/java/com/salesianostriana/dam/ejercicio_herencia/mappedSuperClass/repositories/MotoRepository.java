package com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.repositories;

import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.models.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
