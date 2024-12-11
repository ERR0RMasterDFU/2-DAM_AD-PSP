package com.salesianostriana.dam.api_rest_01;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    //@GetMapping
    /*public ResponseEntity<List<Product>> getAllProducts() {

        /*  1. Obtener del repositorio la lista de productos.
            2. Si la lista está vacía, devolver 404.
            3. Si la lista tiene productos, devolver 200 con la lista.
         

        List<Product> result = new productRepository.getAllProducts();

        if(result.isEmpty) {
            return ResponseEntity.notFound().build();
        }

        result.

    }*/

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.addProduct(product));
    }
}
