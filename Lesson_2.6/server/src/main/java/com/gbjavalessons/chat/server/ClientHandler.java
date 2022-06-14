package com.gbjavalessons.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;

    public ClientHandler (Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.server = server;

        new Thread(() -> {
            try {
                //Authorization

                //Communication with client
                while (true) {
                    String msg = in.readUTF();
                    if(msg.startsWith("/")) {
                        executeCommand(msg);
                        continue;
                    }
                    //My nickname request
                    if (msg.startsWith("/who_am_i")) {
                        sendMessage("Your nickname is: " + username + "\n");
                        continue;
                    } else {
                        server.broadcastMessage(username + " : " + msg);
                    }
                }
            } catch(IOException e){
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    private void executeCommand (String cmd) {
        if(cmd.startsWith("/w" )) {
            String[] tokens = cmd.split("\\s",3);
            server.sendPrivateMessage(this, tokens[1], tokens[2]);
            return;
        }
        if (cmd.startsWith("/exit")) {
            disconnect();
        }
        if (cmd.startsWith("/login ")) {
            String usernameFromLogin = cmd.split("\\s")[1];
            if (!server.isUserInDatabase(usernameFromLogin)) {
                sendMessage("/login_failed Current nickname has already been occupied");
                return;
            }
            if (server.isUserOnline(usernameFromLogin)) {
                sendMessage("/login_failed Current user is online");
                return;
            }

            username = usernameFromLogin;
            sendMessage("/login_ok " + username);
            server.subscribe(this);
            //SQL name change

        } if (cmd.startsWith("/changename ")) {
            String newName = cmd.split("\\s")[1];
            server.nameChanger(newName, this);
            server.broadcastMessage("Next session " + this.getUsername() + " will start as " + newName + "\n");
        }
    }

    private void disconnect() {
        server.unsubscribe(this);
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            disconnect();
        }
    }

    public String getUsername() {
        return username;
    }
}
