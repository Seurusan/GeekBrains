package geekbrains.lesson_1_7;

import geekbrains.lesson_1_7.Cats.Cat;
import geekbrains.lesson_1_7.Cats.Plate;

/**
 * 1. Расширить задачу про котов и тарелки с едой.
 * 2. Сделать так, чтобы в тарелке с едой
 * не могло получиться отрицательного количества еды
 * (например, в миске 10 еды, а кот пытается покушать 15-20).
 * 3. Каждому коту нужно добавить поле сытость
 * (когда создаем котов, они голодны).
 * Если коту удалось покушать (хватило еды), сытость = true.
 * 4. Считаем, что если коту мало еды в тарелке,
 * то он её просто не трогает,
 * то есть не может быть наполовину сыт
 * (это сделано для упрощения логики программы).
 * 5. Создать массив котов и тарелку с едой,
 * попросить всех котов покушать из этой тарелки
 * и потом вывести информацию о сытости котов в консоль.
 * 6. Добавить в тарелку метод, с помощью которого можно
 * было бы добавлять еду в тарелку.
 **/

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 5),
                new Cat("Whitney", 10),
                new Cat("Magdalene", 8)};

        Plate plate = new Plate(10);

        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.println(cats[i].getName() + ": " + cats[i].isFedUp());
            if (!cats[i].isFedUp()) {
                System.out.println(cats[i].getName() + " is still hungry!!!");
            }
        }
        plate.info();

        System.out.println("Oh, no! Kitty is hungry! Let's add some dryfood!");
        plate.add(8);
        System.out.println("Who hasn't eaten yet? Come over here!");
        plate.info();
    }
}
