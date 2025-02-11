package com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2;

import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2.dto.ProductoDto;
import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2.models.Categoria;
import com.salesianostriana.dam.api_03_ejercicio_ultima_hora.apartado2.models.Producto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class MainDeMentira {

    /*@PostConstruct
    public void init() {

        Categoria hortalizas = Categoria.builder()
            .id(1L)
            .nombre("Hortalizas")
        .build();

        Producto p = Producto.builder()
            .id(1L)
            .nombre("Zanhoria")
            .desc("Existe el rumor de que mejoran tanto la vista que curan hasta a los ciegos.")
            .pvp(2.40)
            .imagenes(Arrays.asList("https://cloudfront-eu-central-1.images.arcpublishing.com/prisaradio/UD6AE4NJ4JN35N2SUB4NXPJ5YI.jpg",
                    "https://www.trevijano.com/wp-content/uploads/Zanahoria-1024x1024.jpg"))
            .categoria(hortalizas)
        .build();

        ProductoDto producto = ProductoDto.toProductoDto(p);

    }*/
}
