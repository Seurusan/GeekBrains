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
        broadcastMessage("User " + clientHandler.getUsername() + " has connected \n");
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage("User " + clientHandler.getUsername() + " has disconnected \n");
        broadcastClientList();
    }

    public void broadcastMessage(String message) {
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }
    //Private messages
    public void sendPrivateMessage(ClientHandler sender, String receiverUsername, String message) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(receiverUsername)) {
                client.sendMessage("From: " + sender.getUsername() + " message " + message);
                sender.sendMessage("To: " + receiverUsername + " message " + message);
                return;
            }
        }

        sender.sendMessage("User " + receiverUsername + " doesn't exist.");
    }

    public boolean isUserOnline(String nickname) {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler.getUsername().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    private void broadcastClientList() {
        StringBuilder stringBuilder = new StringBuilder("/clients_list ");
        for (ClientHandler client : clients) {
            stringBuilder.append(client.getUsername()).append(" ");
        }
        stringBuilder.setLength(stringBuilder.length()-1);
        String clientsList = stringBuilder.toString();
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(clientsList);
        }
    }
}
