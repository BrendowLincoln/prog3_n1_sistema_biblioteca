package br.edu.femass.prog3_n1_sistema_biblioteca.dao;

import br.edu.femass.prog3_n1_sistema_biblioteca.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDado {

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
