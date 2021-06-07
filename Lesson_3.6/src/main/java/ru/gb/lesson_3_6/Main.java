package ru.gb.lesson_3_6;

public class Main {

    /**
     *1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     *   Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     *   идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     *   иначе в методе необходимо выбросить RuntimeException.
     *
     *   Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     *   Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     *   Вх: [ 1 2 4 4 2 3 4 ] -> вых: [ ].
     *   Вх: [ 1 2 44 2 34 1 2 ] -> вых: RuntimeException.
     *   Вх: [ 1 2 1 7 ] -> вых: RuntimeException.
     *
     * 2. Написать метод, который проверяет состав массива из чисел 1 и 4.
     *    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     *    если в нем есть что то, кроме 1 и 4, то метод вернет false;
     *
     *    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     *   [ 1 1 1 4 4 1 4 4 ] -> true
     *   [ 1 1 1 1 1 1 ] -> false
     *   [ 4 4 4 4 ] -> false
     *   [ 1 4 4 1 1 4 3 ] -> false
     *
     * 3.* Добавить на серверную сторону сетевого чата логирование событий
     *    (сервер запущен, произошла ошибка, клиент подключился, клиент прислал сообщение/команду).
     */

    public static void main(String[] args) {

    }
}
