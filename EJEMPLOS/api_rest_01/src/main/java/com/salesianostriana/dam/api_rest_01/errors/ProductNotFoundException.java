package com.salesianostriana.dam.api_rest_01.errors;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id) {
        super("No hay producto con ese ID: %d".formatted(id));
    }

    public ProductNotFoundException(String msg) {
        super(msg);
    }

    public ProductNotFoundException() {
        super("No hay productos con esos requisitos de búsqueda");
    }

}
