package com.salesianostriana.dam.ejercicio_seguridad_2.security.jwt.refresh;

import com.salesianostriana.dam.ejercicio_seguridad_2.security.exceptionhandling.JwtException;

public class RefreshTokenException extends JwtException {
    public RefreshTokenException(String s) {
        super(s);
    }
}
