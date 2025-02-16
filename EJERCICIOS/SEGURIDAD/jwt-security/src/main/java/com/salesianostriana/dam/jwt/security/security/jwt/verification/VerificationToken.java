package com.salesianostriana.dam.jwt.security.security.jwt.verification;

import com.salesianostriana.dam.jwt.security.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VerificationToken {

    @Id
    @GeneratedValue
    private UUID id;

    //@MapsId
    @OneToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expireAt;

    @Builder.Default
    private Instant createdAt = Instant.now();

    public String getVerificationToken() {
        return id.toString();
    }

}
