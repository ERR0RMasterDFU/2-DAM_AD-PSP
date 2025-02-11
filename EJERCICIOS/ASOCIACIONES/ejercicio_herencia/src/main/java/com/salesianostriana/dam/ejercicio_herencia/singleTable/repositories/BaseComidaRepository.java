package com.salesianostriana.dam.ejercicio_herencia.singleTable.repositories;

import com.salesianostriana.dam.ejercicio_herencia.singleTable.models.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseComidaRepository <T extends Comida> extends JpaRepository<T, Long> {
}
