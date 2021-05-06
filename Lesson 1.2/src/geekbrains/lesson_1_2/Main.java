package geekbrains.lesson_1_2;

import java.util.Arrays;

public class Main {

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void task_1() {

        // Зададим массив:
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        // Запишем цикл поиска и замены:
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
            // Вывод результата для наглядности
            System.out.print(arr[i] + " ");
        }
    }

    // 2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void task_2() {

        // Объявим массив и выделим под него память (длину):
        int[] arr = new int[8];
        // Заполним массив значениями - через while ради разнообразия:
        int i = 0;
        while (i < 8) {
            arr[i] = i * 3;
            i++;
        }
        // Посмотрим результат
        for (int x : arr) System.out.print(x + " ");
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static void task_3() {

        // Зададим массив
        int[] arr = {1, 5, 33, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        // Умножим значения меньше 6 на 2
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
            // Вывод результата
            System.out.print(arr[i] + " ");
        }
    }

    // 4. Создать квадратный двумерный целочисленный массив
    // (количество строк и столбцов одинаковое) и с помощью цикла(-ов)
    // заполнить его диагональные элементы единицами;

    public static void task_4() {

        // Создадим массив
        int[][] matrix = new int[4][4];
        // Заполним диагональные элементы единицами
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - i - 1] = 1;
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы
    // (без помощи интернета);

    public static void task_5() {

        // Создадим массив
        int[] array = {1, 5, 33, 2, 11, 4, 5, -4, 4, 8, 9, 1};
        // Заполним диагональные элементы единицами
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("Max: " + max + '\n' + "Min: " + min);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место,
    // в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.

    static boolean task_6(int[] array) {

        int sum = Arrays.stream(array).sum();
        System.out.println("Сумма элементов массива: " + sum);
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            check += array[i];
            if (check == (sum / 2)) {
                return true;
            }
        }
        return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.

    public static void task_7() {

        // Решение "в лоб"

        int[] array = {1, 5, 33, 2, 11, 4, 5, -4, 4, 8, 9, 1};
        int n = 0;
        int move = 0;
        if (n > array.length) {
            move = Math.abs(n % array.length);
        } else {
            move = n;
        }
        // Смещение положительное
        if (move > 0) {
            for (int i = 0; i < move; i++) {
                int storage = array[0];
                array[0] = array[array.length - 1];

                for (int j = 1; j < array.length - 1; j++) {
                    array[array.length - j] = array[array.length - j - 1];
                }

                array[1] = storage;
            }
        }
        //Смещение отрицательное
        else if (move < 0) {
            for (int i = 0; i > move; i--) {
                int storage = array[array.length - 1];
                array[array.length - 1] = array[0];

                for (int j = 1; j < array.length - 1; j++) {
                    array[j - 1] = array[j];
                }

                array[array.length - 2] = storage;
            }
        }
        //Проверка результата
        for (int x : array) System.out.print(x + " ");
    }

}
