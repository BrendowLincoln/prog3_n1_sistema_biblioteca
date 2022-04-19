package br.edu.femass.prog3_n1_sistema_biblioteca.controllers;

import br.edu.femass.prog3_n1_sistema_biblioteca.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private StackPane contentArea;

    @FXML
    private Button bookButton;

    @FXML
    private Button userButton;

    @FXML
    private Button loanButton;

    @FXML
    private Button exitButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exitButton.setOnMouseClicked(event -> {
            System.exit(0);
        });

        try {
            Parent fxml =  FXMLLoader.load((getClass().getResource("/br/edu/femass/prog3_n1_sistema_biblioteca/livros.fxml")));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);

            bookButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #487ebf; -fx-pref-width: 160; -fx-background-radius: 0;");
            userButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
            loanButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
        } catch (IOException ex) {
           throw new IllegalArgumentException(ex);
        }
    }

    public void bookSection(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml =  FXMLLoader.load((getClass().getResource("/br/edu/femass/prog3_n1_sistema_biblioteca/livros.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

        bookButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #487ebf; -fx-pref-width: 160; -fx-background-radius: 0;");
        userButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
        loanButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
    }

    public void userSection(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml =  FXMLLoader.load((getClass().getResource("/br/edu/femass/prog3_n1_sistema_biblioteca/usuarios.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

       userButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #487ebf; -fx-pref-width: 160; -fx-background-radius: 0;");
       bookButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
       loanButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
    }

    public void loanSection(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml =  FXMLLoader.load((getClass().getResource("/br/edu/femass/prog3_n1_sistema_biblioteca/emprestimos.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

        loanButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #487ebf; -fx-pref-width: 160; -fx-background-radius: 0;");
        bookButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
        userButton.setStyle("-fx-background-color: #487ebf; -fx-text-fill: #ffffff; -fx-pref-width: 160; -fx-background-radius: 0;");
    }

}