package ru.gb.lesson_3_6;

public class OneAndFourTrue {
    public static boolean check(int[] array) {
        boolean one = false;
        boolean four = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                one = true;
            } else if (array[i] == 4) {
                four = true;
            } else {
                return false;
            }
        }
        return one && four;
    }
}
