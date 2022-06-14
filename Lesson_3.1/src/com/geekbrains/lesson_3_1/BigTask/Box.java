package com.geekbrains.lesson_3_1.BigTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list;

    public Box(T... object) {
        list = Arrays.asList(object);
    }

    public List<T> getList() {
        return list;
    }

    public Box() {
        list = new ArrayList<T>();
    }

    public void addInto(T object) {
        list.add(object);
    }

    public void about() {
        if (list.isEmpty()) {
            System.out.println("The box is empty");
        } else {
            System.out.println("The box contains " + list.size() + " " + list.get(0).toString() + "s");
        }
    }

    public float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return (list.get(0).getWeight())*(list.size());
        }
    }

    public void getWeightAbout() {
        System.out.println("Weight of this box with " + list.get(0).toString() + "s equals " + getWeight());
    }

    public void putIntoAnother(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }

    public boolean compareTo(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }
}
