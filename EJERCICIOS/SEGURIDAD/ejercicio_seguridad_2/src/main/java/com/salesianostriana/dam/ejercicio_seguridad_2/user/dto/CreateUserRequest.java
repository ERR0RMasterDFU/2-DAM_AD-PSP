package com.salesianostriana.dam.ejercicio_seguridad_2.user.dto;

public record CreateUserRequest(
        String username,
        String password,
        String verifyPassword
        //private String avatar;
        //private String fullName;
) {
}
