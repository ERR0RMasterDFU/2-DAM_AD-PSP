package com.salesianostriana.dam.data_jpa_1.controllers;

import com.salesianostriana.dam.data_jpa_1.dto.GetCategoryDto;
import com.salesianostriana.dam.data_jpa_1.models.Category;
import com.salesianostriana.dam.data_jpa_1.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("")
    public List<GetCategoryDto> getAll() {
        return categoryService.findAll()
                .stream()
                .map(GetCategoryDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category nueva) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.save(nueva));
    }

    @PutMapping("/{id}")
    public Category edit(@RequestBody Category aEditar, @PathVariable Long id) {
        return categoryService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}