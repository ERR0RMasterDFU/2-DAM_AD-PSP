package com.salesianostriana.dam.ejercicio_seguridad_2.security.jwt.refresh;

import com.salesianostriana.dam.ejercicio_seguridad_2.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository
        extends JpaRepository<RefreshToken, UUID> {

    @Modifying
    @Transactional
    void deleteByUser(User user);

}