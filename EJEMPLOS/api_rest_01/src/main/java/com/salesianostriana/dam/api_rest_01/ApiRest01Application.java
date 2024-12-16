package com.salesianostriana.dam.api_rest_01;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(description = "Una API de ejemplo para los alumnos de 2º DAM",
        version = "1.0",
        contact = @Contact(
                email = "falla.urdav24@triana.salesianos.edu",
                name = "Luismi"),
        license = @License(
                name = "Kalise para todos"),
        title = "API sobre productos")
)
public class ApiRest01Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiRest01Application.class, args);
    }

}
