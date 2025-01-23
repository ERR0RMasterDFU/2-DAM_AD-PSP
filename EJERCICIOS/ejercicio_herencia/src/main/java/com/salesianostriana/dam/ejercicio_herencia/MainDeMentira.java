package com.salesianostriana.dam.ejercicio_herencia;

import com.salesianostriana.dam.ejercicio_herencia.joined.models.Articulo;
import com.salesianostriana.dam.ejercicio_herencia.joined.models.Publicacion;
import com.salesianostriana.dam.ejercicio_herencia.joined.models.Video;
import com.salesianostriana.dam.ejercicio_herencia.joined.repositories.ArticuloRepository;
import com.salesianostriana.dam.ejercicio_herencia.joined.repositories.PublicacionRepository;
import com.salesianostriana.dam.ejercicio_herencia.joined.repositories.VideoRepository;
import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.models.Bicicleta;
import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.models.Coche;
import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.models.Moto;
import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.repositories.BicicletaRepository;
import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.repositories.CocheRepository;
import com.salesianostriana.dam.ejercicio_herencia.mappedSuperClass.repositories.MotoRepository;
import com.salesianostriana.dam.ejercicio_herencia.singleTable.models.Bebida;
import com.salesianostriana.dam.ejercicio_herencia.singleTable.models.PlatoPrincipal;
import com.salesianostriana.dam.ejercicio_herencia.singleTable.repositories.BebidaRepository;
import com.salesianostriana.dam.ejercicio_herencia.singleTable.repositories.PlatoPrincipalRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final BicicletaRepository biciRepo;
    private final CocheRepository cocheRepo;
    private final MotoRepository motoRepo;

    private final PublicacionRepository publiRepo;
    private final ArticuloRepository artiRepo;
    private final VideoRepository videoRepo;

    private final BebidaRepository bebiRepo;
    private final PlatoPrincipalRepository platoPrinRepo;

    @PostConstruct
    public void init() {

        // HERENCIA MAPPED SUPERCLASS --------------------------------------------------------------------------

        Bicicleta china = Bicicleta.builder()
                .marca("Chinorris")
                .color("Azul")
                .precio(315.60)
                .tipo("Urbana")
                .ruedines(false)
                .build();

        Bicicleta montera = Bicicleta.builder()
                .marca("BH")
                .color("Rojo")
                .precio(480.99)
                .tipo("Mountain Bike")
                .ruedines(true)
                .build();

        Coche familiar = Coche.builder()
                .marca("Honda")
                .color("Varde")
                .matricula("1445 JJS")
                .precio(15.645)
                .tipoMotor("Eléctrico")
                .numPlazas(7)
                .numRuedas(4)
                .build();

        Coche enano = Coche.builder()
                .marca("Peugeot")
                .color("Gris")
                .matricula("9604 BT")
                .precio(13.420)
                .tipoMotor("Diesel")
                .numPlazas(2)
                .numRuedas(4)
                .build();

        Moto harley = Moto.builder()
                .marca("Harley Davidson")
                .color("Marrón")
                .matricula("GR-AP 7726")
                .precio(30.399)
                .tipoMotor("Liquid-cooled")
                .numRuedas(2)
                .cilindrada(1252)
                .build();

        biciRepo.save(china);
        biciRepo.save(montera);
        cocheRepo.save(familiar);
        cocheRepo.save(enano);
        motoRepo.save(harley);

        System.out.println(china);
        System.out.println(montera);
        System.out.println(familiar);
        System.out.println(enano);
        System.out.println(harley);


        // HERENCIA JOINED -------------------------------------------------------------------------------------

        Publicacion publi = Publicacion.builder()
                .titulo("Mi cena de nochevieja")
                .autor("Alfonso María Pérez Filomena")
                .fechaDePublicacion(LocalDate.of(2024, 12, 31))
                .build();

        Articulo arti = Articulo.builder()
                .titulo("Cómo aprender Java")
                .autor("Raúl Clockword Domínguez")
                .fechaDePublicacion(LocalDate.of(2025, 1, 20))
                .contenido("Java es un lenguaje de programación ampliamente utilizado...")
                .numImagenes(3)
                .build();

        Video video = Video.builder()
                .titulo("Tutorial de Hibernate")
                .autor("Hibernate-man")
                .fechaDePublicacion(LocalDate.now())
                .url("https://ejemplo.com/tutorial-hibernate")
                .duracion("30 horas y 59 minutos")
                .build();

        publiRepo.save(publi);
        artiRepo.save(arti);
        videoRepo.save(video);

        System.out.println(publi);
        System.out.println(arti);
        System.out.println(video);


        // HERENCIA SINGLE TABLE -------------------------------------------------------------------------------

        Bebida cerveza = Bebida.builder()
                .nombre("Cerveza")
                .precio(3.50)
                .esAlcoholica(true)
                .build();

        PlatoPrincipal hamburguesa = PlatoPrincipal.builder()
                .nombre("La ultimátum")
                .precio(7.67)
                .calorias(500)
                .build();

        bebiRepo.save(cerveza);
        platoPrinRepo.save(hamburguesa);

        System.out.println(cerveza);
        System.out.println(hamburguesa);
    }
}
