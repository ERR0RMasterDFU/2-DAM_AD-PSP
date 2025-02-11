package com.salesianostriana.dam.ejercicio_herencia.joined.repositories;

import com.salesianostriana.dam.ejercicio_herencia.joined.models.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
