package ru.gb.lesson_3_6;

public class LastFour {
    public static int[] lastFourMethod(int[] array) throws RuntimeException {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                int[] newarray = new int[array.length - i - 1];
                System.arraycopy(array, i + 1, newarray, 0, array.length - i - 1);
                return newarray;
            }
        }
        throw new RuntimeException();
    }
}
