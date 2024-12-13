package com.salesianostriana.dam.api_rest_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    // Imita una clase.
    record Producto(Long id, String nombre) {}

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/producto/123")
    public Producto getProducto() {
        return new Producto(123L,"Un producto muy molón");
    }

    @PostMapping("/producto")
    public Producto addProducto(@RequestBody Producto producto) {
        return producto;
    }


}
