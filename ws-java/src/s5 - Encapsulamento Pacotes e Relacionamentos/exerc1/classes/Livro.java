package exerc1.classes;

import utils.*;

public class Livro {

    protected int id;
    private boolean statusEmprestado = false;
    private String nome;
    private String autor;
    private String genero;
    private Data dataPublicacao;
    private String editora;
    private int edicao;

    /** Construtoras **/

    public Livro(String nome, String autor, String genero, Data dataPublicacao) {

        this.nome = VerificadorValidade.validarTamanhoString(nome);
        this.autor = VerificadorValidade.validarNome(autor);
        this.genero = VerificadorValidade.validarNome(genero);
        this.dataPublicacao = Data.validarData(dataPublicacao);

    }

    public Livro(String nome, String autor, String genero, Data dataPublicacao, String editora) {

        this.nome = VerificadorValidade.validarTamanhoString(nome);
        this.autor = VerificadorValidade.validarNome(autor);
        this.genero = VerificadorValidade.validarNome(genero);
        this.dataPublicacao = Data.validarData(dataPublicacao);
        this.editora = VerificadorValidade.validarTamanhoString(editora);

    }

    public Livro(String nome, String autor, String genero, Data dataPublicacao, String editora, int edicao) {

        this.nome = VerificadorValidade.validarTamanhoString(nome);
        this.autor = VerificadorValidade.validarNome(autor);
        this.genero = VerificadorValidade.validarNome(genero);
        this.dataPublicacao = Data.validarData(dataPublicacao);
        this.editora = VerificadorValidade.validarTamanhoString(editora);
        this.edicao = VerificadorValidade.validarNumeroNatural(edicao);

    }

    /** Getters **/

    public int getId() {
        return this.id;
    }

    public boolean getStatusEmprestado() {
        return this.statusEmprestado;
    }

    public String getNome () {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getAutor () {
        return this.autor;
    }

    public Data getDataPublicacao () {
        return this.dataPublicacao;
    }

    public String getEditora () {
        return this.editora;
    }

    public int getEdicao () {
        return this.edicao;
    }

    /** Setters **/

    public void setId(int id) {
        this.id = id;
    }

    public void setStatusEmprestado(boolean status) {
        this.statusEmprestado = status;
    }

    public void setNome (String nome) {
        this.nome = VerificadorValidade.validarTamanhoString(nome);
    }

    public void setAutor (String autor) {
        this.autor = VerificadorValidade.validarNome(autor);
    }
    
    public void setGenero (String genero) {
        this.genero = VerificadorValidade.validarNome(genero);
    }
    
    public void setDataPublicacao (Data dataPublicacao) {
        this.dataPublicacao = Data.validarData(dataPublicacao);
    }
    
    public void setEditora (String editora) {
        this.editora = VerificadorValidade.validarTamanhoString(editora);
    }
    
    public void setEdicao (int edicao) {
        this.edicao = VerificadorValidade.validarNumeroNatural(edicao);
    }
    
}