package com.example.naloga3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        scene.getStylesheets().add("com/example/naloga3/style.css");
        stage.setMinWidth(730);
        stage.setMinHeight(630);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}