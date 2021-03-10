package geekbrains.lesson_1_4;

/**
 * 1. Полностью разобраться с кодом, попробовать переписать с нуля,
 * стараясь не подглядывать в методичку. - Done
 * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
 * например, с использованием циклов.
 * 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
 * Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
 * 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */

import java.util.Random;
import java.util.Scanner;

public class Functions {
    static void start() {
        char[][] field = emptyField();
        drawField(field);

        while (true) {
            doPlayerMove(field);
            if (firstWinCycle(field, 'X')) {
                System.out.println("Congratulations! You are the Winner! \n");
                drawField(field);
                break;
            }
            if (isDraw(field)) {
                System.out.println("It's a Draw");
                break;
            }
            doAIMove(field);
            if (firstWinCycle(field, 'O')) {
                System.out.println("You lose! \n");
                drawField(field);
                break;
            }
            if (isDraw(field)) {
                System.out.println("It's a Draw");
                break;
            }
            drawField(field);
        }

    }

    // Метод для проверки всех условий на 4-in-a-row

    static boolean firstWinCycle(char[][] field, char symbol) {
        int decdiag1 = 0;
        int decdiag2 = 0;
        int decdiag3 = 0;
        int incdiag1 = 0;
        int incdiag2 = 0;
        int incdiag3 = 0;
        int[] array = {0, 0, 0, 0, 0};
        for (int i = 0; i < field.length; i++) {
            int horizon = 0;
            for (int j = 0; j < field[i].length; j++) {
                horizon = (field[i][j] == symbol) ? ++horizon : 0;
                array[j] = (field[i][j] == symbol) ? ++array[j] : 0;
                if (i == j) {
                    decdiag2 = (field[i][j] == symbol) ? ++decdiag2 : 0;
                }
                if (j - i == 1) {
                    decdiag1 = (field[i][j] == symbol) ? ++decdiag1 : 0;
                }
                if (i - j == 1) {
                    decdiag3 = (field[i][j] == symbol) ? ++decdiag3 : 0;
                }
                if (i == 4 - j) {
                    incdiag2 = (field[i][j] == symbol) ? ++incdiag2 : 0;
                }
                if (i == 3 - j) {
                    incdiag1 = (field[i][j] == symbol) ? ++incdiag1 : 0;
                }
                if (i == 5 - j) {
                    incdiag3 = (field[i][j] == symbol) ? ++incdiag3 : 0;
                }
                if (whatIf(horizon) || whatIf(decdiag1) || whatIf(decdiag2) || whatIf(decdiag3) || whatIf(incdiag2) || whatIf(incdiag1) || whatIf(incdiag3) || whatIfCycle(array)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean whatIf(int a) {
        if (a == 4) {
            return true;
        } else {
            return false;
        }
    }

    static boolean whatIfCycle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3) {
                return true;
            }
        }
        return false;
    }

    static void doPlayerMove(char[][] field) {
        int h, v;
        do {
            h = getCoordinate(field.length, "row");
            v = getCoordinate(field.length, "column");
        } while (isOccupiedCell(field, h, v));

        field[h][v] = 'X';
    }

    // ИИ просчитывает возможность становления 4-ых в ряд на следующий ход и ставит метку
    // в место потенциально решающего знака. Быстродействие хромает, но пока так :)

    static int doAIMove(char[][] field) {
        char[][] testar = copyArray(field);
        System.out.println(("А это наш новый массив: "));
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isFreeCell(testar, i, j)) {
                    testar[i][j] = 'X';
                    if (firstWinCycle(testar, 'X')) {
                        return field[i][j] = 'O';
                    }
                    if (!firstWinCycle(testar, 'X')) {
                        testar = copyArray(field);
                    }
                }
            }
        }
        Random random = new Random();
        int h, v;
        do {
            h = random.nextInt(5);
            v = random.nextInt(5);
        } while (isOccupiedCell(field, h, v));

        return field[h][v] = 'O';
    }

    static char[][] copyArray (char[][] field) {
        char[][] newar = emptyField();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                newar[i][j] = field [i][j];
            }
        }
        return newar;
    }

    static boolean isOccupiedCell(char[][] field, int h, int v) {
        return field[h][v] != '-';
    }

    // Матрица в домашнем задании 5-ого порядка

    static char[][] emptyField() {
        return new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
        };
    }

    static boolean isFreeCell(char[][] field, int h, int v) {
        return !isOccupiedCell(field, h, v);
    }

    static int getCoordinate(int length, String symbol) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("Please input the number of the %s...%n", symbol);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= length);

        return coordinate;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isFreeCell(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

