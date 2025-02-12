package com.salesianostriana.dam.ejercicio_seguridad_2.user.controller;

import com.salesianostriana.dam.ejercicio_seguridad_2.user.dto.CreateUserRequest;
import com.salesianostriana.dam.ejercicio_seguridad_2.user.model.User;
import com.salesianostriana.dam.ejercicio_seguridad_2.user.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
/*
    private final UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<?> createUserWithUserRole(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // Más adelante podemos manejar la seguridad de acceso a esta petición

    @PostMapping("/auth/register/admin")
    public ResponseEntity<User> createUserWithAdminRole(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUserWithAdminRole(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }*/


}