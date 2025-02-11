package com.salesianostriana.dam.data_jpa_1;

import com.salesianostriana.dam.data_jpa_1.models.Product;
import com.salesianostriana.dam.data_jpa_1.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class mainDeMentira {

    private final ProductRepository productRepository;

    /*@PostConstruct
    public void run() {

        Product p = Product.builder()
                .nombre("Evocador")
                .descripcion("Arma esencial para sacar tu persona interior simulando un suicidio.")
                .precio(200.99)
                .build();

        productRepository.save(p);
    }*/
}