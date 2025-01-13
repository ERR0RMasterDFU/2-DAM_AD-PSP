package com.salesianostriana.dam.data_jpa_1.repositories;

import com.salesianostriana.dam.data_jpa_1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
