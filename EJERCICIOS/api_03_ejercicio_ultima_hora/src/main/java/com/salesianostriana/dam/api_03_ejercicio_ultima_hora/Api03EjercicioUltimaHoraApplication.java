package com.salesianostriana.dam.api_03_ejercicio_ultima_hora;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
    @Info(
        description = "Una API de ejemplo para mí :O",
        version = "1.0",
        contact = @Contact(email = "falla.urdav24@triana.salesianos.edu", name = "David"
        ), license = @License(name = "KaLise para todos"),
        title = "API sobre productos"
    )
)
public class Api03EjercicioUltimaHoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(Api03EjercicioUltimaHoraApplication.class, args);
    }

}
