package com.salesianostriana.dam.ejercicio01_asociaciones.repositories;

import com.salesianostriana.dam.ejercicio01_asociaciones.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
