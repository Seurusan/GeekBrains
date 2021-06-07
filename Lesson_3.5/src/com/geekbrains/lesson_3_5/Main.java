package com.geekbrains.lesson_3_5;

import com.geekbrains.lesson_3_5.Classes.Car;
import com.geekbrains.lesson_3_5.Classes.Race;
import com.geekbrains.lesson_3_5.Classes.Road;
import com.geekbrains.lesson_3_5.Classes.Tunnel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {

        //Счётчики для начала и конца гонки
        CyclicBarrier prepared = new CyclicBarrier(CARS_COUNT+1);
        ArrayBlockingQueue<Car> finished = new ArrayBlockingQueue<>(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), prepared, finished);
            new Thread(cars[i]).start();
        }

        try {
            prepared.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            prepared.await();
            System.out.println("Победил " + finished.take().getName());
            prepared.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
