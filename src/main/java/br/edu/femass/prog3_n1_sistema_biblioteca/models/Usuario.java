package br.edu.femass.prog3_n1_sistema_biblioteca.models;

import java.time.LocalDate;

public class Usuario {
    private String nome;
    private String cpf;
    private String matricula;
    private TipoUsuario tipo;
    private Integer prazoDevolucao;

    public Usuario(String nome, String cpf, String matricula, TipoUsuario tipo, Integer prazoDevolucao) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.tipo = tipo;
        this.prazoDevolucao = prazoDevolucao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Integer getPrazoDevolucao() {
        return prazoDevolucao;
    }

    @Override
    public String toString() {
        return "None: " + this.getNome() + " - " + this.tipo.name();
    }
}
