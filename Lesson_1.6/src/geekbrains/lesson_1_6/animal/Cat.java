package geekbrains.lesson_1_6.animal;

import geekbrains.lesson_1_6.animal.Animal;

public class Cat extends Animal {
    public static int counter = 0;
    public Cat(String name) {
        super(name, 200, 0);
        counter++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(" and since it's a cat - it can't swim...");
    }
}
