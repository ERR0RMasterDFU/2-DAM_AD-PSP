package com.example.api02_monumentos.error;

public class MonumentBadRequestException extends RuntimeException{

    public MonumentBadRequestException(Long id) {
        super("No se ha podido procesar los datos introducidos.");
    }

    public MonumentBadRequestException(String msg) {
        super(msg);
    }

    public MonumentBadRequestException() {
        super("No se ha podido procesar los datos introducidos.");
    }

}
