package geekbrains.lesson_1_8;

import javax.swing.*;
import java.awt.*;

public class Main {

    /**
     * 1. Реализовать вычисление выражения для операций
     * (без учета приоритетов): умножение, сложение, вычитание, деление
     * 2. Реализовать вычисление квадратного корня
     * 3. * Попробовать применить ScriptEngine
     * для вычисления сложный математических выражений/
     * 4. *** Реализовать вычисление выражения для операций
     * (с учетом приоритетов и без ScriptEngine):
     * умножение, сложение, вычитание, деление
     **/

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
