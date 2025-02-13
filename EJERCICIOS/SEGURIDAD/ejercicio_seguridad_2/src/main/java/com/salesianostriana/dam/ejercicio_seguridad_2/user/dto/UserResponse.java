package com.salesianostriana.dam.ejercicio_seguridad_2.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianostriana.dam.ejercicio_seguridad_2.user.model.User;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String token
) {

    public static UserResponse of (User user) {
        return new UserResponse(user.getId(), user.getUsername(), null);
    }

    public static UserResponse of (User user, String token) {
        return new UserResponse(user.getId(), user.getUsername(), token);
    }

}
