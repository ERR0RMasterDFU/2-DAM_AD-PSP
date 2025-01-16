package com.salesianostriana.dam.ejercicio01_asociaciones.services;

import com.salesianostriana.dam.ejercicio01_asociaciones.models.Categoria;
import com.salesianostriana.dam.ejercicio01_asociaciones.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay categorías con esos criterios de búsqueda");
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay Categoría con ID: "+ id));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria edit(Categoria categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoría con ID: "+ id));

    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

}
