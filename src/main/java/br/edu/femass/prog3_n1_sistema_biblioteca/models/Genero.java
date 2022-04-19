package br.edu.femass.prog3_n1_sistema_biblioteca.models;

public enum Genero {
    INFORMATICA("Informática"),
    CONTABILIDADE("Contabilidade"),
    ADMINISTRACAO("Administração"),
    DIREITO("Direito"),
    MEDICINA("Medicina"),
    NUTRICAO("Nutrição"),
    ENFERMAGEM("Enfermagem"),
    QUIMICA("Química"),
    FISICA("Física"),
    HISTORIA("História"),
    BIOLOGIA("Biologia");

    private String nome;

    Genero(String nome) {
        this.nome = nome;
    }
}
