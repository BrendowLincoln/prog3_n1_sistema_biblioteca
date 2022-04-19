package br.edu.femass.prog3_n1_sistema_biblioteca.dao;

import br.edu.femass.prog3_n1_sistema_biblioteca.models.Livro;
import br.edu.femass.prog3_n1_sistema_biblioteca.models.Usuario;

import java.util.List;

public class UsuarioDao implements Dao<Usuario> {

    private UsuarioDado usuarioDado = new UsuarioDado();

    @Override
    public void gravar(Usuario objeto) throws Exception {
        usuarioDado.getUsuarios().add(objeto);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioDado.getUsuarios();
    }

    @Override
    public void excluir(Usuario objeto) throws Exception {
        usuarioDado.getUsuarios().remove(objeto);

    }
}
