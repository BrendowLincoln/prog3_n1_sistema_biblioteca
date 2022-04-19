package br.edu.femass.prog3_n1_sistema_biblioteca.controllers;

import br.edu.femass.prog3_n1_sistema_biblioteca.dao.UsuarioDao;
import br.edu.femass.prog3_n1_sistema_biblioteca.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class UsuariosController implements Initializable {

    UsuarioDao usuarioDao = new UsuarioDao();

    @FXML
    private TextField registerInput;

    @FXML
    private TextField nameInput;

    @FXML
    private ComboBox<TipoUsuario> userTypeCombobox;

    @FXML
    private TextField cpfInput;

    @FXML
    private ListView<Usuario> userList;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<TipoUsuario> userTypes = FXCollections.observableArrayList(TipoUsuario.values());
        userTypeCombobox.setItems(userTypes);

        enableForm(false, false);

        updateList();
    }

    @FXML
    private void enableForm(Boolean enable, Boolean isEditing) {
        registerInput.setDisable(!enable);
        nameInput.setDisable(!enable);
        cpfInput.setDisable(!enable);
        userTypeCombobox.setDisable(!enable);

        addButton.setDisable(enable);
        cancelButton.setVisible(enable);
        saveButton.setVisible(enable);
        deleteButton.setVisible(isEditing);
    }

    @FXML
    private void clearForm() {
        registerInput.setText("");
        nameInput.setText("");
        cpfInput.setText("");
        userTypeCombobox.setValue(null);
    }

    @FXML
    private void addUser(ActionEvent event) {
        enableForm(true, false);
    }

    @FXML
    private void cancelEditing(ActionEvent event) {
        clearForm();
        enableForm(false, false);
    }

    @FXML
    private void saveBook(ActionEvent event) {

        List<String> userResgisters = usuarioDao.listar().stream().map(livro -> livro.getMatricula()).collect(Collectors.toList());

        try {

            if(!userResgisters.contains(registerInput.getText())) {
                Usuario newUser = userTypeCombobox.getValue() == TipoUsuario.Aluno ?
                    new Aluno(
                        nameInput.getText(),
                        cpfInput.getText(),
                        registerInput.getText(),
                        userTypeCombobox.getValue()
                    ) :
                    new Professor(
                            nameInput.getText(),
                            cpfInput.getText(),
                            registerInput.getText(),
                            userTypeCombobox.getValue()
                    );
                usuarioDao.gravar(newUser);
            } else {

                Usuario changeUser = usuarioDao.listar().stream().filter(livro -> livro.getMatricula() == registerInput.getText()).findFirst().get();

                changeUser.setMatricula(registerInput.getText());
                changeUser.setNome(nameInput.getText());
                changeUser.setCpf(cpfInput.getText());


                clearForm();
                enableForm(false, false);

            }


        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        clearForm();
        enableForm(false, false);
        updateList();
    }

    @FXML
    private void userListMouseClicked(MouseEvent evento) {
        clearForm();
        showUser();
    }

    @FXML
    private void userListKeyPressed(KeyEvent evento) {
        clearForm();
        showUser();
    }

    private void updateList() {
        List<Usuario> usuarios = null;
        try {
            usuarios = usuarioDao.listar();
        } catch (Exception e) {
            usuarios = new ArrayList<Usuario>();
        }
        ObservableList<Usuario> usuariosOb = FXCollections.observableArrayList(usuarios);
        userList.setItems(usuariosOb);
    }

    @FXML
    private void deleteUser(ActionEvent event) throws Exception {
        Usuario deletedUser = usuarioDao.listar().stream().filter(livro -> livro.getMatricula() == registerInput.getText()).findFirst().get();
        usuarioDao.excluir(deletedUser);
        clearForm();
        updateList();
    }


    private void showUser() {

        enableForm(true, true);

        Usuario usuario = userList.getSelectionModel().getSelectedItem();

        if (usuario==null) return;
        registerInput.setText(usuario.getMatricula());
        registerInput.setDisable(true);
        nameInput.setText(usuario.getNome());
        userTypeCombobox.setValue(usuario.getTipo());
        cpfInput.setText(usuario.getCpf());

    }
}
