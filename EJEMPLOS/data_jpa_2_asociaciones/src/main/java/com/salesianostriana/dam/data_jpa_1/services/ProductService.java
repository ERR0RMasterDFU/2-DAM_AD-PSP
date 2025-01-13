package com.salesianostriana.dam.data_jpa_1.services;

import com.salesianostriana.dam.data_jpa_1.dto.EditProductCmd;
import com.salesianostriana.dam.data_jpa_1.models.Product;
import com.salesianostriana.dam.data_jpa_1.repositories.ProductRepository;
import com.salesianostriana.dam.data_jpa_1.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;


    public List<Product> findAll() {
        List<Product> result = productRepo.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay productos con esos criterios de búsqueda");
        return result;
    }

    public Product findById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));
    }

    public Product save(Product producto) {
        return productRepo.save(producto);
    }

    public Product save(EditProductCmd nuevo) {
        return productRepo.save(Product.builder()
                .nombre(nuevo.nombre())
                .descripcion(nuevo.descripcion())
                .precio(nuevo.precio())
                //.categoria(categoriaRepository.getReferenceById(nuevo.categoriaId()))
                .categoria(categoryRepo.findById(nuevo.categoriaId()).orElse(null))
                .build());
    }

    public Product edit(EditProductCmd editProductoCmd, Long id) {
        return productRepo.findById(id)
                .map(old -> {
                    old.setNombre(editProductoCmd.nombre());
                    old.setDescripcion(editProductoCmd.descripcion());
                    old.setPrecio(editProductoCmd.precio());
                    //old.setCategoria(categoriaRepository.getReferenceById(editProductoCmd.categoriaId()));
                    old.setCategoria(categoryRepo.findById(editProductoCmd.categoriaId()).orElse(null));
                    return productRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

}
