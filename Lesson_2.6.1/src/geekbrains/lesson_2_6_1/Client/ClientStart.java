package geekbrains.lesson_2_6_1.Client;

import java.io.IOException;

public class ClientStart {
    public static void main(String[] args) throws IOException {
        ClientCore client = new ClientCore();
        System.out.println("Client started. Connecting to localhost: 8918");

        new Thread(() -> {
            try {
                client.readMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                client.sendMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}