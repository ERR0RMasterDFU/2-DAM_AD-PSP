package com.example.api02_monumentos.controllers;

import com.example.api02_monumentos.models.Monument;
import com.example.api02_monumentos.services.MonumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
public class MonumentController {

    @Autowired
    private MonumentService monuServ;

    @GetMapping("/list")
    public ResponseEntity<List<Monument>> getAllMonuments(
            @RequestParam(required = false, value = "countryName", defaultValue = "") String countryName,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        List<Monument> result = monuServ.getAllMonuments(countryName, sortDirection);

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monument> getMonumentById(@PathVariable long id) {
        return ResponseEntity.of(monuServ.getMonument(id));
    }

    @PostMapping
    public ResponseEntity<Monument> createMonument(@RequestBody Monument m) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monuServ.addMonument(m));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monument> editMonument(@RequestBody Monument m, @PathVariable long id) {
        return ResponseEntity.of(monuServ.editMonument(m, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Monument> deleteMonumentById(@PathVariable long id) {
        monuServ.deleteMonument(id);
        return ResponseEntity.noContent().build();
    }
}
