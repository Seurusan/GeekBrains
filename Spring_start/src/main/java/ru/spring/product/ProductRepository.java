package ru.spring.product;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductRepository {
    private List<Product> products;

    @Autowired
    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "" + products;
    }
}
