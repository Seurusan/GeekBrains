package com.geekbrains.lesson_3_4;

/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
 * (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 */

public class ThreadTask {
    static Object monitor = new Object();
    static volatile int currentSym = 1;
    static final int repeat = 5;

    public static void startThreads () {
        new Thread(() -> {
            try {
                for (int i = 0; i < repeat; i++) {
                    synchronized (monitor) {
                        while (currentSym != 1) {
                            monitor.wait();
                        }
                        System.out.print('A');
                        currentSym = 2;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < repeat; i++) {
                    synchronized (monitor) {
                        while (currentSym != 2) {
                            monitor.wait();
                        }
                        System.out.print('B');
                        currentSym = 3;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < repeat; i++) {
                    synchronized (monitor) {
                        while (currentSym != 3) {
                            monitor.wait();
                        }
                        System.out.print('C');
                        currentSym = 1;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
