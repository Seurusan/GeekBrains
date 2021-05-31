package com.geekbrains.lesson_3_1;

import com.geekbrains.lesson_3_1.BigTask.Apple;
import com.geekbrains.lesson_3_1.BigTask.Box;
import com.geekbrains.lesson_3_1.BigTask.Orange;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * <p>
 * 2. Написать метод, который преобразует массив в ArrayList;
 * <p>
 * 3. Большая задача:
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
 */

public class Main {

    public static void main(String[] args) {

        Box<Orange> oBox1 = new Box();
        Box<Orange> oBox2 = new Box();
        Box<Apple> aBox = new Box();

        oBox1.addInto(new Orange());
        oBox1.addInto(new Orange());
        oBox1.addInto(new Orange());

        for (int i = 0; i < 4; i++) {
            oBox2.addInto(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            aBox.addInto(new Apple());
        }

        oBox1.about();
        oBox2.about();
        aBox.about();

        oBox1.getWeightAbout();
        oBox2.getWeightAbout();
        aBox.getWeightAbout();

        System.out.println("oBox1 equals aBox? " + oBox1.compareTo(aBox));
        System.out.println("oBox2 equals aBox? " + oBox2.compareTo(aBox));

        oBox1.putIntoAnother(oBox2);

        // oBox1.putIntoAnother(aBox);
        //Required type:
        //Box
        //        <Orange>
        //Provided:
        //Box
        //        <Apple>

        oBox1.about();
        oBox2.about();
        aBox.about();
    }
}
