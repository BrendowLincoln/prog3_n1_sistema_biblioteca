package br.edu.femass.prog3_n1_sistema_biblioteca.dao;

import br.edu.femass.prog3_n1_sistema_biblioteca.models.Copia;

import java.util.ArrayList;
import java.util.List;

public class CopiaDao implements Dao<Copia> {
    private static List copia = new ArrayList<Copia>();

    @Override
    public void gravar(Copia objeto) throws Exception {
        copia.add(objeto);
    }

    @Override
    public List<Copia> listar() {
        return copia;
    }

    @Override
    public void excluir(Copia objeto) throws Exception {
        copia.remove(objeto);
    }
}
