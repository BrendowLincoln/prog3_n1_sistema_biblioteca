package br.edu.femass.prog3_n1_sistema_biblioteca.models;

import java.time.LocalDate;

public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Usuario usuario;
    private Copia copia;
}
