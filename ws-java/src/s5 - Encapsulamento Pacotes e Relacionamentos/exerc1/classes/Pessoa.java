package exerc1.classes;

import utils.*;

import java.util.Set;
import java.util.HashSet;

public class Pessoa {

    protected int id; //definido pela biblioteca associada

    private String nome;
    private int idade;
    private Biblioteca bibliotecaAssociada;
    private Set<Livro> livros = new HashSet<Livro>();

    /** Construtoras **/

    public Pessoa(String nome, int idade, Biblioteca biblioteca) {
        this.nome = VerificadorValidade.validarNome(nome);
        this.idade = VerificadorValidade.validarIdade(idade);
        this.bibliotecaAssociada = biblioteca;
        biblioteca.addAssociado(this);
    }

    public Pessoa(String nome, int idade) {
        this.nome = VerificadorValidade.validarNome(nome);
        this.idade = VerificadorValidade.validarIdade(idade);
    }

    /** Getters **/

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public Biblioteca getBibliotecaAssociada() {
        return this.bibliotecaAssociada;
    }

    public Set<Livro> getLivros() {
        return this.livros;
    }

    /** Setters **/

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = VerificadorValidade.validarNome(nome);
    }

    public void setIdade(int idade) {
        this.idade = VerificadorValidade.validarIdade(idade);
    }

    public void setBibliotecaAssociada(Biblioteca biblioteca) {
        this.bibliotecaAssociada = biblioteca;
    }

    /** Métodos **/

    public void imprimirLivros() {
        
        System.out.format("\n=-=-=-=- Livros pegos emprestado por %s =-=-=-=-\n", this.getNome());
        for(Livro livro : this.livros) System.out.format("Nome: %s | Autor: %s\n", livro.getNome(), livro.getAutor());
        
    }

    public void associarBiblioteca(Biblioteca biblioteca) {
        biblioteca.addAssociado(this);
        setBibliotecaAssociada(biblioteca);
    }

    public void cancelarAssociacao(Biblioteca biblioteca) {
        biblioteca.removerAssociado(this);
        this.bibliotecaAssociada = null;
    }

    public void solicitarEmprestimo(Livro livroEmprestimo) {

        Livro livroEmprestado = this.bibliotecaAssociada.emprestimoLivro(this, livroEmprestimo);
        if (livroEmprestado != null)
            this.livros.add(livroEmprestado);

    }

    public void devolverLivro(String nome) {

        for (Livro livro : this.livros) {
            if (livro.getNome().equalsIgnoreCase(nome)) {
                this.bibliotecaAssociada.fecharEmprestimo(this, livro);
                break;
            }
        }

    }
    
}