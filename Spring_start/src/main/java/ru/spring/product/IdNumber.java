package ru.spring.product;

public class IdNumber {
    private int id;
    static int flag = 0;

    public IdNumber() {
        this.id = flag;
        flag++;
    }

    public int getId() {
        return id;
    }
}
