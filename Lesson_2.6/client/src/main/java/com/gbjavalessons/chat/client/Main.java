package com.gbjavalessons.chat.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    /**
     * 1. Добавить в сетевой чат запись локальной истории в текстовый файл на клиенте.
     * Для каждой учетной записи файл с историей должен называться history_[login].txt.
     * (Например, history_login1.txt, history_user111.txt)
     * 2.** После загрузки клиента показывать ему последние 100 строк истории чата.
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
