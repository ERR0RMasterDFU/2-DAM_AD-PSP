package com.salesianostriana.dam.ejercicio_herencia.joined.repositories;

import com.salesianostriana.dam.ejercicio_herencia.joined.models.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
