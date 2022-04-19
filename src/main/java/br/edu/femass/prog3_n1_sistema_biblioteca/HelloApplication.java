package br.edu.femass.prog3_n1_sistema_biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    double x, y;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("home.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Biblioteca PROG 3");

       stage.centerOnScreen();

        stage.setScene(new Scene(root.load()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}