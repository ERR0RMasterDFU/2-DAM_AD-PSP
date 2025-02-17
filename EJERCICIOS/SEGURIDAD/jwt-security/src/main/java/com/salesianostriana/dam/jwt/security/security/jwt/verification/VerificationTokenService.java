package com.salesianostriana.dam.jwt.security.security.jwt.verification;

import com.salesianostriana.dam.jwt.security.user.model.User;
import com.salesianostriana.dam.jwt.security.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;


    public VerificationToken create(User user) {

        verificationTokenRepository.deleteByUser(user);

        return verificationTokenRepository.save(
                VerificationToken.builder()
                        .user(user)
                        //.token(UUID.randomUUID().toString())
                        .expireAt(Instant.now().plus(Duration.ofDays(1))) // Expira en 24 horas
                        .build()
        );
    }

    public void verifyToken(VerificationToken verificationToken) {
        if (verificationToken.getExpireAt().isBefore(Instant.now())) {
            verificationTokenRepository.delete(verificationToken);
            throw new VerificationTokenException("Token de verificación caducado.");
        } else {
            User user = verificationToken.getUser();
            user.setVerified(true);
            userRepository.save(user);
            verificationTokenRepository.delete(verificationToken);
        }
    }

    public Optional<VerificationToken> findByToken(String token) {
        return verificationTokenRepository.findById(UUID.fromString(token));
    }

}
