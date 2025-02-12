package com.salesianostriana.dam.ejercicio_seguridad_2.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class PasswordEncoderConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {

    }

}
