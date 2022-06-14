package com.gbjavalessons.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
                while (true) {
                    String msg = in.readUTF();
                    if (msg.startsWith("/login ")) {
                        String usernameFromLogin = msg.split("\\s")[1];

                        if (server.isNickBusy(usernameFromLogin)) {
                            sendMessage("/login_failed Current nickname has already been occupied");
                            continue;
                        }

                        username = usernameFromLogin;
                        sendMessage("/login_ok " + username);
                        server.subscribe(this);
                        break;
                    }
                }
                //Communication with client
                while (true) {
                    String msg = in.readUTF();
                    //My nickname request
                    if (msg.startsWith("/who_am_i")) {
                        sendMessage("Your nickname is: " + username + "\n");
                        continue;
                    } if (msg.startsWith("/exit")) {
                        disconnect();
                    } if (msg.startsWith("/w ")) {
                        server.privateMessage(msg, username);
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

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }
    //Private messages
    public void sendPrivateMessage(String message, int index, String name) throws IOException {
        String result = message.substring(index);
        out.writeUTF(name + " whispers: " + result);
    }

    public String getUsername() {
        return username;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }
}
