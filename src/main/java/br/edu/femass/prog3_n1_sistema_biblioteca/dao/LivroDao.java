package br.edu.femass.prog3_n1_sistema_biblioteca.dao;

import br.edu.femass.prog3_n1_sistema_biblioteca.models.Livro;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

public class LivroDao implements Dao<Livro>{
    private LivroDado livroDados = new LivroDado();

    @Override
    public void gravar(Livro objeto) throws Exception {
        livroDados.getLivros().add(objeto);
    }

    @Override
    public List<Livro> listar() {
        return livroDados.getLivros();
    }

    @Override
    public void excluir(Livro objeto) throws Exception {
        livroDados.getLivros().remove(objeto);

    }
}
