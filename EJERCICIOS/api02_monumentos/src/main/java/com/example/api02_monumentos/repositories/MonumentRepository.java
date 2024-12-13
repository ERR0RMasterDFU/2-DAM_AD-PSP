package com.example.api02_monumentos.repositories;

import com.example.api02_monumentos.models.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, Long> {

}
