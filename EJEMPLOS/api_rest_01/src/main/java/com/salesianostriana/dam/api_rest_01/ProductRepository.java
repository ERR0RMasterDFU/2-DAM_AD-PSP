package com.salesianostriana.dam.api_rest_01;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private HashMap<Long, Product> products = new HashMap<>();

    public void inint() {
        addProduct(Product.builder().id(1L).name("Gorra de mario").price(200.0).build());
        addProduct(Product.builder().id(2L).name("Espada Maestra").price(400.0).build());
        addProduct(Product.builder().id(3L).name("Falchion").price(600.0).build());
        addProduct(Product.builder().id(4L).name("Varita estelar").price(800.0).build());
        addProduct(Product.builder().id(5L).name("Látigo 'Matavampiros'").price(1000.0).build());
    }

    public Product addProduct(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> getProduct(long id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> getAllProducts() {
        return List.copyOf(products.values());
    }

    /*public Optional<Product> editProduct(Long id, Product newProductValue) {

    }*/

    public void deleteProduct(Long id) {
        products.remove(id);
    }

}
