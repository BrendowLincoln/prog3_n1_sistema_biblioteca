package br.edu.femass.prog3_n1_sistema_biblioteca.models;

import java.time.LocalDate;

public class Professor extends Usuario {

    public Professor(String name, String cpf, String matricula, TipoUsuario tipo) {
        super(name, cpf, matricula, tipo,30);
    }
}
