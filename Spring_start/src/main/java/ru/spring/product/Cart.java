package ru.spring.product;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Cart {
    private List<Product> cart;

    public Cart() {
    }

    @Autowired
    public Cart(List<Product> cart) {
        this.cart = cart;
    }

    public void addCart(Product product) {
        cart.add(product);
    }

    public void remCart(List<Product> cart, Product product) {
        cart.remove(product);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart=" + cart +
                '}';
    }
}
