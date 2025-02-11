package com.example.ejercicio02_asociaciones;

import com.example.ejercicio02_asociaciones.models.CursoOnline;
import com.example.ejercicio02_asociaciones.models.Profesor;
import com.example.ejercicio02_asociaciones.models.Video;
import com.example.ejercicio02_asociaciones.repositories.CursoOnlineRepository;
import com.example.ejercicio02_asociaciones.repositories.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class mainDeMentira {

    private final ProfesorRepository profeRepo;
    private final CursoOnlineRepository cursoRepo;

    @PostConstruct
    public void init () {

        Profesor luismi = Profesor.builder()
                .nombre("Luis Miguel López Magaña")
                .email("luismi404@gmail.com")
                .puntuacion(10)
                .build();

        Profesor miguel = Profesor.builder()
                .nombre("Miguel Campos Rivera")
                .email("miguel200@gmail.com")
                .puntuacion(8.45)
                .build();


        CursoOnline dart = CursoOnline.builder()
                .nombre("Primeros pasos en Dart")
                .puntuacion(7.5)
                .profesor(miguel)
                .build();

        CursoOnline spring = CursoOnline.builder()
                .nombre("Desarrollo de API REST con Spring Boot")
                .puntuacion(9.1)
                .build();


        Video dartVideo1 = Video.builder()
                .orden(1)
                .titulo("Variables")
                .descripcion("En este vídeo aprenderemos lo que son las variables.")
                .url("https://openwebinars.net/academia/aprende/dart-primeros-pasos/16145/variables")
                .curso(dart)
                .build();

        Video dartVideo2 = Video.builder()
                .orden(2)
                .titulo("Ciclo If-Else")
                .descripcion("En este vídeo aprenderemos lo qué son los ciclos If-Else.")
                .url("https://openwebinars.net/academia/aprende/dart-primeros-pasos/16155/if-else")
                .curso(dart)
                .build();

        Video dartVideo3 = Video.builder()
                .orden(3)
                .titulo("Ciclo For")
                .descripcion("En este vídeo aprenderemos lo qué son los ciclos for.")
                .url("https://openwebinars.net/academia/aprende/dart-primeros-pasos/16155/for")
                .build();

        Video springVideo1 = Video.builder()
                .orden(1)
                .titulo("Manejo básico de errores")
                .descripcion("En este vídeo aprenderemos cómo manejar las excepciones de manera sencilla.")
                .url("https://openwebinars.net/academia/aprende/api-rest-spring-boot/basic-errors")
                .curso(spring)
                .build();

        Video springVideo2 = Video.builder()
                .orden(2)
                .titulo("Implementación de DTO")
                .descripcion("En este vídeo aprenderemos lo qué son los DTO.")
                .url("https://openwebinars.net/academia/aprende/api-rest-spring-boot/dto")
                .build();

        profeRepo.save(luismi);
        profeRepo.save(miguel);
        cursoRepo.save(dart);
        cursoRepo.save(spring);






    }
}
