package com.salesianostriana.dam.api_rest_01;

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


    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false, value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        //List<Product> result = productRepository.getAllProducts();
        List<Product> result = productRepository.query(max, sortDirection);

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return ResponseEntity.of(productRepository.getProduct(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.addProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, @PathVariable long id) {
        return ResponseEntity.of(productRepository.editProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable long id) {
        productRepository.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
