package com.salesianostriana.dam.ejercicio01_asociaciones;

import com.salesianostriana.dam.ejercicio01_asociaciones.models.Categoria;
import com.salesianostriana.dam.ejercicio01_asociaciones.models.Producto;
import com.salesianostriana.dam.ejercicio01_asociaciones.repositories.CategoriaRepository;
import com.salesianostriana.dam.ejercicio01_asociaciones.repositories.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void init() {

        Categoria alimento = Categoria.builder()
                .nombre("Alimento")
                .build();

        Categoria vegetales = Categoria.builder()
                .nombre("Vegetales")
                .categoriaMismaRelacion(alimento)
                .build();

        Categoria frutas = Categoria.builder()
                .nombre("Frutas")
                .categoriaMismaRelacion(alimento)
                .build();

        categoriaRepository.save(alimento);
        categoriaRepository.save(vegetales);
        categoriaRepository.save(frutas);

        Producto p = Producto.builder()
                .nombre("Manzana")
                .pvp(0.60)
                .categoria(frutas)
                .build();

        productoRepository.save(p);
    }
}
