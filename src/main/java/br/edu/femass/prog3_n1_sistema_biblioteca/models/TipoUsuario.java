package br.edu.femass.prog3_n1_sistema_biblioteca.models;

public enum TipoUsuario {

    Aluno("Aluno"),
    Professor("Contabilidade");

    private String name;

    TipoUsuario(String name) {
        this.name = name;
    }
}
