module br.edu.femass.prog3_n1_sistema_biblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.edu.femass.prog3_n1_sistema_biblioteca to javafx.fxml;
    exports br.edu.femass.prog3_n1_sistema_biblioteca;
    exports br.edu.femass.prog3_n1_sistema_biblioteca.controllers;
    opens br.edu.femass.prog3_n1_sistema_biblioteca.controllers to javafx.fxml;
}