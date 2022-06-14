package com.gbjavalessons.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is launched on port " + port + "...");
            while (true) {
                System.out.println("Waiting for user");
                Socket socket = serverSocket.accept();
                System.out.println("Connection established");
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public void broadcastMessage(String message) throws IOException {
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }
    //Private messages
    public void privateMessage(String message, String name) throws IOException {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler.getUsername().equals(message.split(" ")[1])) {
                int index = message.indexOf(message.split(" ")[2]);
                clientHandler.sendPrivateMessage(message, index, name);
            }
        }
    }

    public boolean isNickBusy (String nickname) {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler.getUsername().equals(nickname)) {
                return true;
            }
        }
        return false;
    }
}
