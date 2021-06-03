package com.geekbrains.lesson_3_5.Classes;

import com.geekbrains.lesson_3_5.Main;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore limit;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        //Лимит на половину участников
        limit = new Semaphore(Main.CARS_COUNT/2);
    }

    @Override
    public void go(Car c) {
        try {
            //Имитация туннеля
            if (limit.tryAcquire()) {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                limit.acquire();
            }

            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            limit.release();
        }
    }
}