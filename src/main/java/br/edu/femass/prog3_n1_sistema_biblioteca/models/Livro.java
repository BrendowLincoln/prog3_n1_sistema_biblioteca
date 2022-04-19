package br.edu.femass.prog3_n1_sistema_biblioteca.models;

import br.edu.femass.prog3_n1_sistema_biblioteca.dao.CopiaDao;
import lombok.*;

@Data
public class Livro {
    private Integer codigo;
    private Integer ano;
    private String edicao;
    private String titulo;
    private Autor autor;
    private Genero genero;

    private CopiaDao copiaDao = new CopiaDao();

    public static Integer proximoCodigo = 1;

    public Livro() { }

    public Livro(String titulo, Genero genero, Autor autor, String edicao, Integer ano) throws Exception {

        this.codigo = proximoCodigo;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.edicao = edicao;
        this.ano = ano;

        this.copiaDao.gravar(new Copia(true, this));

        proximoCodigo++;
    }

    public Integer getCodigo() { return codigo; }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
