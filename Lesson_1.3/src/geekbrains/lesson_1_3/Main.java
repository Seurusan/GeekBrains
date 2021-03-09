package geekbrains.lesson_1_3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // 1. Написать программу, которая загадывает случайное число
    // от 0 до 9 и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
    // чем загаданное, или меньше. После победы или проигрыша выводится запрос
    // – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    public static void main(String[] args) {
        //guessGame();
        guessTheWord();
    }

    static void guessGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int tries = 3;

        int playerChoice;

        while (true) {
            int rNumber = random.nextInt(10);
            System.out.println("Let the game begin!");

            do {
                playerChoice = scanner.nextInt();

                if (rNumber == playerChoice) {
                    System.out.println("Congratulations! You win!");
                    break;
                } else {
                    String message = rNumber > playerChoice ? "Bigger than" : "Less than";
                    System.out.println(message);
                }
                tries--;
            } while (tries > 0);

            System.out.println("Choose: 0 - to end; 1 - to start new game");
            int newGame = scanner.nextInt();
            if (newGame == 0) {
                System.out.println("See you next time!");
                break;
            }
            if (newGame == 1) {
                guessGame();
            } else {
                System.out.println("Command does not exists. Exiting the application");
                break;

            }
        }
    }

    /**
     * 2. * Создать массив из слов
     * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
     * "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
     * "pepper", "pineapple", "pumpkin", "potato"}.
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно можно пользоваться:
     * String str = "apple";
     * char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово.
     * Используем только маленькие буквы.
     */

    static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String playerChoice;

        while (true) {
            int i = (int) Math.floor(Math.random() * words.length);
            System.out.println("Да начнётся игра! (Загаданное слово - " + words[i] + ")");
            System.out.println("Введите Ваше слово:");

            label:
            do {
                playerChoice = scanner.nextLine();

                for (int n = 0; n < 15; n++) {
                    if (n < words[i].length() && n < playerChoice.length()) {
                        char a = playerChoice.charAt(n);
                        char b = words[i].charAt(n);
                        System.out.print(a = a == b ? a : '#');
                    } else {
                        System.out.print('#');
                    }
                }
                System.out.print("\n");
            } while (playerChoice.compareTo(words[i]) != 0);

            System.out.println("Congratulations! You win!");
            break;
        }
    }
}
