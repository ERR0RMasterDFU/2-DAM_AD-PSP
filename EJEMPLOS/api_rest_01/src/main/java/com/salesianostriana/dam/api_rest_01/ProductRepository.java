package com.salesianostriana.dam.api_rest_01;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final HashMap<Long, Product> products = new HashMap<>();

    public void init() {
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

    Optional<Product> editProduct(Long id, Product newProductValue) {
        return Optional.ofNullable(products.computeIfPresent(id, (k, v) -> {
            v.setName(newProductValue.getName());
            v.setPrice(newProductValue.getPrice());
            return v;
        }));
    }

    public void deleteProduct(Long id) {
        products.remove(id);
    }

    public List<Product> query(double maxPrice, String sortDirection) {
        List<Product> data = new ArrayList<>(products.values());
        List<Product> result;

        if (maxPrice < 0) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(p -> p.getPrice() <= maxPrice)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Product::getName));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Product::getName).reversed());

        return Collections.unmodifiableList(result);
    }

}
