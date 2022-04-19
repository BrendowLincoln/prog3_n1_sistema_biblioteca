package br.edu.femass.prog3_n1_sistema_biblioteca.dao;

import br.edu.femass.prog3_n1_sistema_biblioteca.models.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao implements Dao<Emprestimo> {
    EmprestimoDado emprestimoDado = new EmprestimoDado();

    @Override
    public void gravar(Emprestimo objeto) throws Exception {
        emprestimoDado.getEmprestimos().add(objeto);
    }

    @Override
    public List<Emprestimo> listar() throws Exception {
        return emprestimoDado.getEmprestimos();
    }

    @Override
    public void excluir(Emprestimo objeto) throws Exception {
        emprestimoDado.getEmprestimos().remove(objeto);
    }
}
