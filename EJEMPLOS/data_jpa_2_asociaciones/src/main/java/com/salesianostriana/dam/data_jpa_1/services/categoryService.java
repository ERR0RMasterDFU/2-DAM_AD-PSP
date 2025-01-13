package com.salesianostriana.dam.data_jpa_1.services;

import com.salesianostriana.dam.data_jpa_1.models.Category;
import com.salesianostriana.dam.data_jpa_1.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class categoryService {

    private final CategoryRepository repo;


    public List<Category> findAll() {
        /*
            Obtener todos los productos
            Si la lista está vacía
                Lanzo excepción
         */
        List<Category> result = repo.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay categorías con esos criterios de búsqueda");
        return result;
    }

    public Category findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay Categoría con ID: "+ id));
    }

    public Category save(Category categoria) {
        return repo.save(categoria);
    }

    public Category edit(Category categoria, Long id) {
        return repo.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return repo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoría con ID: "+ id));

    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}

