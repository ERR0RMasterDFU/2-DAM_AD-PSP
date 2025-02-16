package com.salesianostriana.dam.jwt.security.security.jwt.verification;

import com.salesianostriana.dam.jwt.security.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, UUID> {

    @Modifying
    @Transactional
    void deleteByUser(User user);

    Optional<VerificationToken> findByToken(String token);

}
