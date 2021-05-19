package com.geekbrains.lesson_3_1.Methods;

public class ArrayGenSwap {

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 */

    public static <T> void arrayGenSwap (T[] array, int firstIndex, int secondIndex)  {
        T shelf = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = shelf;
    }
}
