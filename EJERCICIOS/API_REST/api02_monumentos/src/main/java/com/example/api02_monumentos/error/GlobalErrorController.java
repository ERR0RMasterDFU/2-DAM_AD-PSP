package com.example.api02_monumentos.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;


@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonumentNotFoundException.class)
    public ProblemDetail handleMonumentNotFound(MonumentNotFoundException ex) {
        ProblemDetail exception = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        exception.setTitle("Monumento no encontrado");
        exception.setType(URI.create("https://www.salesianos-triana.edu/errors/monument-not-found"));
        exception.setProperty("author", "David");

        return exception;

    }

    @ExceptionHandler(MonumentBadRequestException.class)
    public ProblemDetail handleMonumentBadRequest(MonumentBadRequestException ex) {
        ProblemDetail exception = ProblemDetail
                .forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        exception.setTitle("Datos sin procesar");
        exception.setType(URI.create("https://www.salesianos-triana.edu/errors/monument-bad-request"));
        exception.setProperty("author", "David");

        return exception;

    }

}
