package com.salesianostriana.dam.api_rest_01.controllers;

import com.salesianostriana.dam.api_rest_01.dto.GetProductListDto;
import com.salesianostriana.dam.api_rest_01.dto.CreateProductDto;
import com.salesianostriana.dam.api_rest_01.models.Product;
import com.salesianostriana.dam.api_rest_01.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    //public List<Product> getAll(
    public GetProductListDto getAll(
            @RequestParam(required = false, value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        return GetProductListDto.of(productService.query(max, sortDirection));
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.get(id);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody CreateProductDto product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.add(product.toProduct()));
    }

    @PutMapping("/{id}")
    public Product edit(
            @RequestBody Product product,
            @PathVariable("id") Long productId) {

        return productService.edit(productId, product);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }


}