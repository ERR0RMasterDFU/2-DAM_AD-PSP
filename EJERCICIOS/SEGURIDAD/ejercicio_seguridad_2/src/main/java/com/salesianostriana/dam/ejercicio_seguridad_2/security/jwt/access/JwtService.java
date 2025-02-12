package com.salesianostriana.dam.ejercicio_seguridad_2.security.jwt.access;

import com.salesianostriana.dam.ejercicio_seguridad_2.user.model.User;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

//import io.jsonwebtoken.Jwts.header;

public class JwtService {

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX= "Bearer";

    //@Value("${jwt.secret}")
    private String jwtSecret;

    //@Value("${jwt.duration}")
    private String jwtLifeInMinutes;

    private JwtParser jwtParser;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {

        secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        //jwtParser = JwtParser.

    }
    /*
    public String generateToken(User user) {

        Date tokenExpirationDate =
                Date.from(
                        LocalDateTime
                                .now()
                                .plusMinutes(jwtLifeInMinutes)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()
                )

        return Jwts.builder()
                .header().type(TOKEN_TYPE)
                .and()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(tokenExpirationDate)
                .signWith(secretKey)
                .compact;

    }*/

}
