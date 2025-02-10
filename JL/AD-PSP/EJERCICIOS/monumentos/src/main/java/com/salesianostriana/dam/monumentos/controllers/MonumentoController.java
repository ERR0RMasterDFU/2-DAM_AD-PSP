package com.salesianostriana.dam.monumentos.controllers;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.services.MonumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/monumentos")
public class MonumentoController {

    @Autowired
    private MonumentoService service;


    //OBTENER LISTA MONUMENTOS

    @GetMapping
    public ResponseEntity<List<Monumento>> obtenerListaTodosMonumentos () {
        return new ResponseEntity<>(service.obtenerListaMonumentos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    //BUSCAR MONUMENTO POR ID
    public ResponseEntity<Optional<Monumento>> obtenerMonumentoPorId (@PathVariable("id") long id) {
        if(service.obtenerMonumentoPorId(id) != null) {
            return new ResponseEntity<>(service.obtenerMonumentoPorId(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    // CREAR UN MONUMENTO
    public ResponseEntity<Monumento> crearMonumento (@RequestBody Monumento monumento) {
        return new ResponseEntity<>(service.crearMonumento(monumento), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    //EDITAR MONUMENTO
    public ResponseEntity<Monumento> editarMonumento (@PathVariable("id") long id, @RequestBody Monumento monumento) {
        return new ResponseEntity<>(service.actualizarMonumento(monumento,id), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    //BORRAR MONUMENTO POR ID
    public ResponseEntity<Void> borrarMonumento (@PathVariable("id") long id) {
        service.borrarMonumentoPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}