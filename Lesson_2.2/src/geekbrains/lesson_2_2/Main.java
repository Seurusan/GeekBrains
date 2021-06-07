package geekbrains.lesson_2_2;

import Methods.MyArrayDataException;
import Methods.MyArraySizeException;
import Methods.TwoDimArray;

public class Main {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось
     * (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
     * 3. В методе main() вызвать полученный метод,
     * обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
     */

    public static void main(String[] args) {
        try {
            TwoDimArray.start();
        } catch (MyArraySizeException e) {
            System.out.println("Not a 4x4 matrix!");
        } catch (MyArrayDataException d) {
            System.out.println("Incorrect type of data in cell " + d.i + ":" + d.j);
        }
    }
}
