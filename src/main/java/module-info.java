module br.edu.femass.prog3_n1_sistema_biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires static xstream;
    exports br.edu.femass.prog3_n1_sistema_biblioteca;
    exports br.edu.femass.prog3_n1_sistema_biblioteca.controllers;
    opens br.edu.femass.prog3_n1_sistema_biblioteca.controllers to javafx.fxml;
}


