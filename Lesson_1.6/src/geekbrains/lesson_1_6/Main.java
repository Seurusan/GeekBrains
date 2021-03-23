package geekbrains.lesson_1_6;

import geekbrains.lesson_1_6.animal.Animal;
import geekbrains.lesson_1_6.animal.AnimalGroup;
import geekbrains.lesson_1_6.animal.Cat;
import geekbrains.lesson_1_6.animal.Dog;

import java.util.Arrays;

public class Main {

    /**
     * 1. Создать классы Собака и Кот с наследованием от класса Животное.
       2. Все животные могут бежать и плыть.
       В качестве параметра каждому методу передается длина препятствия.
       Результатом выполнения действия будет печать в консоль.
       (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
       3. У каждого животного есть ограничения на действия
       (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
       4. * Добавить подсчет созданных котов, собак и животных.
     */

    public static void main(String[] args) {
        Animal[] beasts = {
                new Cat("Blackie"),
                new Dog("Charlie"),
                new Cat("Nyancat"),
                new Dog("Hatiko"),
                new Cat("Donovan"),
        };

        AnimalGroup group = new AnimalGroup();
        group.add(new Cat("Blackie"));
        group.add(new Dog("Charlie"));
        group.add(new Cat("Nyancat"));
        group.add(new Dog("Hatiko"));
        group.add(new Cat("Donovan"));

        for (int i = 0; i < beasts.length; i++) {
            beasts[i].run(300);
            beasts[i].swim(150);
        }

        System.out.println("Total: " + group.getCount().getCounter());
        System.out.println("Cats: " + group.getCount().getCats());
        System.out.println("Dogs: " + group.getCount().getDogs());
    }
}
