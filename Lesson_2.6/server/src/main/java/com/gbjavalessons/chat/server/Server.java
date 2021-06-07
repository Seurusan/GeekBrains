package com.gbjavalessons.chat.server;

import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private static Connection connection;
    private static Statement stmt;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is launched on port " + port + "...");
            while (true) {
                System.out.println("Waiting for user");
                try {
                    connect();
                    System.out.println("Connection established");
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    disconnect();
                }
                Socket socket = serverSocket.accept();
                System.out.println("Connection established");
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //SQL methods
    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Users.db");
        stmt = connection.createStatement();
    }

    private static void disconnect(){
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
//        try {
//            connect();
//            ResultSet rs = stmt.executeQuery("SELECT name FROM Usernames;");
//            while (rs.next()) {
//                if (clientHandler.getUsername().equals(rs.getString("name"))) {
//                    System.out.println(rs);
                    clients.add(clientHandler);
                    broadcastMessage("User " + clientHandler.getUsername() + " has connected \n");
                    broadcastClientList();
//                } else {
//
//                }
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            disconnect();
//        }
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

    public void messageIntoFile(String message) throws IOException {
        for (ClientHandler clientHandler : clients) {
            FileWriter writer = new FileWriter("C:\\Code\\history_" + clientHandler.getUsername() + ".txt", true);
            writer.append(message);
            writer.close();
        }
    }

    public void nameChanger(String newName, ClientHandler clientHandler) {
        try {
            connect();
            stmt.executeUpdate("UPDATE Usernames SET name = '" + newName + "' WHERE name = '" + clientHandler.getUsername() + "';");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    //Private messages
    public void sendPrivateMessage(ClientHandler sender, String receiverUsername, String message) throws IOException {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(receiverUsername)) {
                //Receiver actions
                client.sendMessage("From: " + sender.getUsername() + " message " + message);
                FileWriter writer = new FileWriter("C:\\Code\\history_" + client.getUsername() + ".txt", true);
                writer.append("From: " + sender.getUsername() + " message " + message);
                writer.close();
                //Sender actions
                sender.sendMessage("To: " + receiverUsername + " message " + message);
                FileWriter writer_s = new FileWriter("C:\\Code\\history_" + sender.getUsername() + ".txt", true);
                writer_s.append("To: " + receiverUsername + " message " + message);
                writer_s.close();
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

    public boolean isUserInDatabase(String nickname) {
        try {
            connect();
            ResultSet rs = stmt.executeQuery("SELECT name FROM Usernames;");
            while (rs.next()) {
                if (nickname.equals(rs.getString("name"))) {
                    rs.close();
                    return true;
                }
            }
            rs.close();
            disconnect();
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong...");
            disconnect();
            return false;
        }
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
