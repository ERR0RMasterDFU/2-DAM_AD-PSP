package com.salesianostriana.dam.ejercicio_seguridad_2.user.repo;

import com.salesianostriana.dam.ejercicio_seguridad_2.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findFirstByUsername(String username);

}
