package geekbrains.lesson_2_6_1.Server;

import java.io.IOException;

public class ServerStart {
    public static void main(String[] args) throws IOException {
        ServerCore server = new ServerCore();
        server.start();
        server.catchClient();
        new Thread(() -> {
            while (true) {
                String txt = null;
                try {
                    txt = server.in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (txt != null) {
                    try {
                        server.sendMessage(txt);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            try {
                server.writeToConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}