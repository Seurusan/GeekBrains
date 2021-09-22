package ru.gb.web.application;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Product {

    int id;
    String title;
    int cost;

    static int id_num = 0;

    public Product() {

        Random r = new Random();

        this.id = id_num;
        this.title = randString(r);
        this.cost = r.nextInt(1000);

        id_num ++;
    }

    public static String start() {
        Product product = new Product();
        return (String.valueOf(product.id) + " " + product.title + " " + String.valueOf(product.cost));
    }

//    public String start() {
//        Product product = new Product();
//        return
//    }

    public static String randString (Random random) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        char[] text = new char[7];
        for (int i = 0; i < 7; i++)
        {
            text[i] = characters.charAt(random.nextInt(26));
        }
        return new String(text);
    }
}
