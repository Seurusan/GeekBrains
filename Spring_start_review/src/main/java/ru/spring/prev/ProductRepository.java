package ru.spring.prev;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>(
                List.of(
                        new Product(1, "Toys", 100F),
                        new Product(2, "Spirits", 500F),
                        new Product(3, "Bakery", 10F),
                        new Product(4, "T-shirts", 50F),
                        new Product(5, "Ground meat", 20F)));
    }

    public Optional<Product> findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }

    public List<Product> findAll() {
        return products;
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + products +
                '}';
    }
}
