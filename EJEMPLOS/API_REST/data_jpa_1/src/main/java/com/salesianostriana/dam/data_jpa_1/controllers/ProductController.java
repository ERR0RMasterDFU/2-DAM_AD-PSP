package com.salesianostriana.dam.data_jpa_1.controllers;

import com.salesianostriana.dam.data_jpa_1.models.Product;
import com.salesianostriana.dam.data_jpa_1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        productService.save(nuevo));
    }

    @PutMapping("/{id}")
    public Product edit(@RequestBody Product aEditar,
                         @PathVariable Long id) {
        return productService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
