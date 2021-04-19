package Methods;

import java.util.Random;
import java.util.Scanner;

public class TwoDimArray {
    public static void start() throws MyArraySizeException, MyArrayDataException {
        //Пользовательский ввод размера матрицы с последующей проверкой и выдачей исключения
        System.out.println("Input the number of columns/rows:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n!=4) {
            throw new MyArraySizeException();
        }
        //Заполнение ячеек матрицы потенциальными целыми числами и S, которая станет исключением
        String[] filler = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "S"};
        String[][] matrix = new String[n][n];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = filler[random.nextInt(filler.length)];
            }
        }
        //Вывод матрицы для наглядности
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        //Собственно поиск и обработка исключения/вывод суммы ячеек если данные корректны
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                try {
                    count = count + Integer.parseInt(matrix[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Data is correct. The sum of cells is " + count);
    }
}
