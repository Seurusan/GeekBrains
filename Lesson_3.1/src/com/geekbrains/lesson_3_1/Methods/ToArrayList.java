package com.geekbrains.lesson_3_1.Methods;

import java.util.Arrays;
import java.util.List;

public class ToArrayList {

    /**
   * 2. Написать метод, который преобразует массив в ArrayList;
   */

    public static <T> List<T> toArrayList (T[] array) {
        return Arrays.asList(array);
    }
}
