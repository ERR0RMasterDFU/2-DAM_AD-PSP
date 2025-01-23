package com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.repositories;

import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.models.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
}
