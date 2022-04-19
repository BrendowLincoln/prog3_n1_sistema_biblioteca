package br.edu.femass.prog3_n1_sistema_biblioteca.dao;


import br.edu.femass.prog3_n1_sistema_biblioteca.models.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoDado {

    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
