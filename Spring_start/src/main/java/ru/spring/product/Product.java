package ru.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ru.spring.product.IdNumber;
import ru.spring.product.NameOf;
import ru.spring.product.Price;

/**
 * 1. Есть класс Product (id, название, цена).
 *    Товары хранятся в бине ProductRepository, в виде List<Product>, при старте в него нужно добавить 5 любых товаров.
 * 2. ProductRepository позволяет получить весь список или один товар по id.
 *    Создаем бин Cart, в который можно добавлять и удалять товары по id.
 * 3. Написать консольное приложение, позволяющее управлять корзиной.
 * 4. При каждом запросе корзины из контекста, должна создаваться новая корзина.
 */

//@Scope(value = "prototype")
public class Product {
    private IdNumber idNumber;
    private NameOf nameOf;
    private Price price;

    public Product() {
    }
    @Autowired
    public Product(IdNumber idNumber, NameOf nameOf, Price price) {
        this.idNumber = idNumber;
        this.nameOf = nameOf;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n idNumber=" + this.idNumber.getId() + ", nameOf=" + nameOf + ", price=" + price;
    }
}
