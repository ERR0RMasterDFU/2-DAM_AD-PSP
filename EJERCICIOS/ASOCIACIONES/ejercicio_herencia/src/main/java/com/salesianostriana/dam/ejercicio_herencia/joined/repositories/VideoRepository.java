package com.salesianostriana.dam.ejercicio_herencia.joined.repositories;

import com.salesianostriana.dam.ejercicio_herencia.joined.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
