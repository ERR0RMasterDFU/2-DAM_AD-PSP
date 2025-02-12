package com.salesianostriana.dam.ejercicio_seguridad_2.user.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username
) {

    public static UserResponse of(){

    }

}
