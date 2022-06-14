package geekbrains.lesson_2_6_1.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ServerCore {
    BufferedReader in = null;
    PrintWriter out = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    String input;
    BufferedReader console = null;

    void start() {
        try {
            serverSocket = new ServerSocket(8918);
        } catch (IOException e) {
            System.out.println("Can't access port 8918");
            System.exit(1);
        }
        System.out.print("Initialization, waiting for connection...");
    }

    void catchClient() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Connection is established");
        } catch (IOException e) {
            System.out.println("Connection error");
            System.exit(1);
        }

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Waiting for messages...");
    }

    void sendMessage(String msg) throws IOException {
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        LocalTime localTime = LocalTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = localTime.format(formatter);
        if (msg.equalsIgnoreCase("Exit")) close();
        out.println(formattedTime + " - " + msg);
        System.out.println(msg);
    }

    void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
}
