package br.edu.femass.prog3_n1_sistema_biblioteca.controllers;

import br.edu.femass.prog3_n1_sistema_biblioteca.dao.CopiaDao;
import br.edu.femass.prog3_n1_sistema_biblioteca.dao.LivroDao;
import br.edu.femass.prog3_n1_sistema_biblioteca.models.Autor;
import br.edu.femass.prog3_n1_sistema_biblioteca.models.Genero;
import br.edu.femass.prog3_n1_sistema_biblioteca.models.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LivrosController implements Initializable {

    Livro bookReference = new Livro();
    LivroDao livroDao = new LivroDao();
    CopiaDao copiaDao = new CopiaDao();

    @FXML
    private TextField codeInput;

    @FXML
    private TextField titleInput;

    @FXML
    private ComboBox<Genero> genresCombobox;

    @FXML
    private TextField authorFirstName;

    @FXML
    private TextField authorNickname;

    @FXML
    private TextField editionInput;

    @FXML
    private TextField yearInput;


    @FXML
    private TextField copyQuantityInput;

    @FXML
    private ListView<Livro> bookList;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button addCopyButton;

    @FXML
    private HBox copyQuantitySection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Genero> genres = FXCollections.observableArrayList(Genero.values());
        genresCombobox.setItems(genres);

        enableForm(false, false);

        updateList();
    }

    @FXML
    private void enableForm(Boolean enable, Boolean isEditing) {
        codeInput.setDisable(!enable);
        titleInput.setDisable(!enable);
        genresCombobox.setDisable(!enable);
        authorFirstName.setDisable(!enable);
        authorNickname.setDisable(!enable);
        editionInput.setDisable(!enable);
        copyQuantityInput.setDisable(!enable);
        yearInput.setDisable(!enable);

        addButton.setDisable(enable);
        cancelButton.setVisible(enable);
        saveButton.setVisible(enable);
        deleteButton.setVisible(isEditing);
        addCopyButton.setVisible(isEditing);
        copyQuantitySection.setVisible(isEditing);
    }

    @FXML
    private void clearForm() {
        codeInput.setText("");
        titleInput.setText("");
        genresCombobox.setValue(null);
        authorFirstName.setText("");
        authorNickname.setText("");
        editionInput.setText("");
        copyQuantityInput.setText("");
        yearInput.setText("");
    }

    @FXML
    private void addBook(ActionEvent event) {
        enableForm(true, false);
        codeInput.setEditable(false);
        codeInput.setText(bookReference.proximoCodigo.toString());


    }

    @FXML
    private void cancelEditing(ActionEvent event) {
        clearForm();
        enableForm(false, false);
    }

    @FXML
    private void saveBook(ActionEvent event) {

        List<Integer> booksCode = livroDao.listar().stream().map(livro -> livro.getCodigo()).collect(Collectors.toList());

       try {

           if(!booksCode.contains(Integer.parseInt(codeInput.getText()))) {
               Livro newBook = new Livro(
                       titleInput.getText(),
                       genresCombobox.getValue(),
                       new Autor(authorFirstName.getText(), authorNickname.getText()),
                       editionInput.getText(),
                       Integer.parseInt(yearInput.getText())
               );
               livroDao.gravar(newBook);
           } else {

               Livro changeBook = livroDao.listar().stream().filter(livro -> livro.getCodigo() == Integer.parseInt(codeInput.getText())).findFirst().get();

               changeBook.setTitulo(titleInput.getText());
               changeBook.setGenero(genresCombobox.getValue());
               changeBook.getAutor().setNome(authorFirstName.getText());
               changeBook.getAutor().setSobrenome(authorNickname.getText());
               changeBook.setEdicao(editionInput.getText());
               changeBook.setAno(Integer.parseInt(yearInput.getText()));

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
    private void bookListMouseClicked(MouseEvent evento) {
        clearForm();
        showBook();
    }

    @FXML
    private void bookListKeyPressed(KeyEvent evento) {
        clearForm();
        showBook();
    }

    private void updateList() {
        List<Livro> livros = null;
        try {
            livros = livroDao.listar();
        } catch (Exception e) {
            livros = new ArrayList<Livro>();
        }
        ObservableList<Livro> livrosOb = FXCollections.observableArrayList(livros);
        bookList.setItems(livrosOb);
    }


    private void showBook() {



        enableForm(true, true);

        Livro livro = bookList.getSelectionModel().getSelectedItem();

        if (livro==null) return;
        codeInput.setText(livro.getCodigo().toString());
        titleInput.setText(livro.getTitulo());
        genresCombobox.setValue(livro.getGenero());
        authorFirstName.setText(livro.getAutor().getNome());
        authorNickname.setText(livro.getAutor().getSobrenome());
        editionInput.setText(livro.getCodigo().toString());
        yearInput.setText(livro.getAno().toString());

        Long bookCopyQuantity = copiaDao.listar().stream().filter(copia -> copia.getLivro().equals(livro)).count();
        copyQuantityInput.setText(bookCopyQuantity.toString());



    }

    @FXML
    private void deleteBook(ActionEvent event) throws Exception {
        Livro deletedBook = livroDao.listar().stream().filter(livro -> livro.getCodigo() == Integer.parseInt(codeInput.getText())).findFirst().get();
        livroDao.excluir(deletedBook);
        clearForm();
        updateList();
    }


    @FXML
    private void addNewCopy(ActionEvent event)  {



    }


}
