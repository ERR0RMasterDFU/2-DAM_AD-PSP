package com.example.api02_monumentos.error;

public class MonumentNotFoundException extends RuntimeException{

    public MonumentNotFoundException(Long id) {
        super("No existe ningún monumento con ese ID: %d".formatted(id));
    }

    public MonumentNotFoundException(String msg) {
        super(msg);
    }

    public MonumentNotFoundException() {
        super("No hay monumentos con los requisitos de búsqueda introducidos.");
    }

}