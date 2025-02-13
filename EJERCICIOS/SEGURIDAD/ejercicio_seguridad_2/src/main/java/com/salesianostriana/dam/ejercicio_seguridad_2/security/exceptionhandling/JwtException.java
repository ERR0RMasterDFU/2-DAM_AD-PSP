package com.salesianostriana.dam.ejercicio_seguridad_2.security.exceptionhandling;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
