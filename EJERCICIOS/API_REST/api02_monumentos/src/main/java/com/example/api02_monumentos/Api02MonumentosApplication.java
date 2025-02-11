package com.example.api02_monumentos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(description = "API de monumentos que no terminamos de ver con JL.",
        version = "1.0",
        contact = @Contact(
                email = "falla.urdav@triana.salesianos.edu",
                name = "David"),
        license = @License(
                name = "Licencia"),
        title = "API de monumentos")
)
public class Api02MonumentosApplication {

    public static void main(String[] args) {
        SpringApplication.run(Api02MonumentosApplication.class, args);
    }

}