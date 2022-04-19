package br.edu.femass.prog3_n1_sistema_biblioteca.controllers;

import br.edu.femass.prog3_n1_sistema_biblioteca.dao.CopiaDao;
import br.edu.femass.prog3_n1_sistema_biblioteca.dao.LivroDao;
import br.edu.femass.prog3_n1_sistema_biblioteca.models.Copia;
import br.edu.femass.prog3_n1_sistema_biblioteca.models.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CopiasController implements Initializable {

    private Livro livro;

    Copia copyReference = new Copia();
    LivroDao livroDao = new LivroDao();
    CopiaDao copiaDao = new CopiaDao();


    public CopiasController(Livro livro) {
        this.livro = livro;
    }



    @FXML
    private TextField codeInput;

    @FXML
    private ListView<Copia> copyList;

    @FXML
    private CheckBox isFixedCheck;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enableForm(true, false);
    }

    @FXML
    public void saveCopy(ActionEvent event) {

    }

    @FXML
    private void enableForm(Boolean enable, Boolean isEditing) {
        codeInput.setDisable(!enable);
        isFixedCheck.setDisable(!enable);
        cancelButton.setVisible(enable);
        saveButton.setVisible(enable);
        deleteButton.setVisible(isEditing);
    }

    @FXML
    private void clearForm() {
        codeInput.setText("");
        isFixedCheck.setSelected(false);
    }

    @FXML
    private void copyListMouseClicked(MouseEvent evento) {
        clearForm();
        showCopy();
    }

    @FXML
    private void copyListKeyPressed(KeyEvent evento) {
        clearForm();
        showCopy();
    }


    private void showCopy() {

        enableForm(true, true);

        Copia copia = copyList.getSelectionModel().getSelectedItem();

        if (copia==null) return;
        codeInput.setText(copia.getCodigo().toString());
        isFixedCheck.setSelected(copia.geteFixo());
    }

    @FXML
    private void cancelEditing(ActionEvent event) {
        clearForm();
        enableForm(false, false);
    }

    @FXML
    private void deleteCopy(ActionEvent evet) {

    }
}
