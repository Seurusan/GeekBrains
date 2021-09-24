package ru.spring.prev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>(
                List.of(
                    new Order(1, LocalDate.now(), 100F, Collections.emptyList()),
                    new Order(2, LocalDate.of(2021,2,20), 500F, Collections.emptyList()),
                    new Order(3, LocalDate.of(2021, 9,21), 10F, Collections.emptyList())));
    }

    public Optional<Order> findById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }

    public List<Order> findAll() {
        return orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }
}
