package br.edu.femass.prog3_n1_sistema_biblioteca.dao;

import java.util.*;

public interface Dao<T> {

    public void gravar(T objeto) throws Exception;
    public List<T> listar() throws Exception;
    public void excluir(T objeto) throws Exception;
}
