package com.salesianostriana.dam.data_jpa_1.repositories;

import com.salesianostriana.dam.data_jpa_1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
