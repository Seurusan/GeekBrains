package com.gbjavalessons.chat.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Statement;

public class Controller {
    @FXML
    TextField msgField, usernameField;

    @FXML
    TextArea msgArea;

    @FXML
    HBox loginPanel, msgPanel;

    @FXML
    ListView<String> clientList;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;
    private static Connection connection;
    private static Statement stmt;

    public void sendMsg(ActionEvent actionEvent) {
        String msg = msgField.getText() + '\n';
        try {
            out.writeUTF(msg);
            msgField.clear();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Can't send the message", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void login(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connect();
        }

        if (usernameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Name can't be empty",
                    ButtonType.OK);
            alert.showAndWait();
            return;
        }

        try {
            out.writeUTF("/login " + usernameField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username = username;
        if (username != null) {
            loginPanel.setVisible(false);
            loginPanel.setManaged(false);
            msgPanel.setVisible(true);
            msgPanel.setManaged(true);
        } else {
            loginPanel.setVisible(true);
            loginPanel.setManaged(true);
            msgPanel.setVisible(false);
            msgPanel.setManaged(false);
        }
    }

    public void connect() {
        try {
            socket = new Socket("localhost", 8920);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread dataThread = new Thread(() -> {
                try {
                    //Authorization
                    while (true) {
                        String msg = in.readUTF();

                        if (msg.startsWith("/login_ok ")) {
                            setUsername(msg.split("\\s")[1]);
                            break;
                        }

                        if (msg.startsWith("/login_failed ")) {
                            String cause = msg.split("\\s", 2)[1];
                            msgArea.appendText(cause + '\n');
                        }

                    }

                    //communication
                    while (true) {
                        String msg = in.readUTF();
                        if(msg.startsWith("/")) {
                            executeCommand(msg);
                            continue;
                        }
                        msgArea.appendText(msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            dataThread.start();

        } catch (IOException e) {
            throw new RuntimeException("Unable to connect to server [localhost: 8919]");
        }
    }

    private void executeCommand(String cmd) {
        if (cmd.startsWith("/clients_list")) {
            String[] tokens = cmd.split("\\s");

            Platform.runLater(()-> {
                clientList.getItems().clear();
                for (int i = 1; i < tokens.length; i++) {
                    clientList.getItems().add(tokens[i]);
                }
            });
        }
    }

    public void disconnect() throws IOException {
        //Disconnect actions
        try {
            setUsername(null);
            msgArea.clear();
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "You've disconnected", ButtonType.OK);
            alert.showAndWait();
        }
    }

}