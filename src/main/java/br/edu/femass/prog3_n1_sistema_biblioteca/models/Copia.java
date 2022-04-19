package br.edu.femass.prog3_n1_sistema_biblioteca.models;

public class Copia {
    private Integer codigo;
    private Boolean eFixo;
    private Livro livro;

    private static Integer proximoCodigo = 1;

    public Copia() { }

    public Copia(Boolean eFixo, Livro livro) {
        this.codigo = proximoCodigo;
        this.eFixo = eFixo;
        this.livro = livro;

        proximoCodigo++;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Boolean geteFixo() {
        return eFixo;
    }

    public void seteFixo(Boolean eFixo) {
        this.eFixo = eFixo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "#" + this.codigo + " - Título:" + this.livro.getTitulo() + " - " + (this.eFixo ? "Fixo" : "Normal");
    }
}
