package exerc1;

import exerc1.test.RegistroTeste;
import utils.Data;
import exerc1.classes.*;

// 1. Faça um programa para controle de empréstimo de livros, com as classes Emprestimo, Livro e Pessoa

public class Main {

    public static void main(String...args) {

        Biblioteca machadoDeAssis = RegistroTeste.criarBiblioteca();

        Pessoa yoda = new Pessoa("Yoda Dagobah", 100, machadoDeAssis);
        machadoDeAssis.listarAssociados();

        yoda.solicitarEmprestimo(machadoDeAssis.getLivroDisponivel("100 endgames you must know", "Jesus de La Villa"));
        yoda.listarLivros();

        machadoDeAssis.getAssociadoPeloNome("Pedra Pedroso")
                .solicitarEmprestimo(machadoDeAssis.getLivroDisponivel("Cosmos", "Carl Sagan"));
        machadoDeAssis.getAssociadoPeloNome("Pedra Pedroso").listarLivros();

        machadoDeAssis.addLivro(new Livro("Viva la vida", "Frank Osbourn", "Ficção", new Data(1, 2, 2000)));
        machadoDeAssis.listarLivrosDisponiveis();
        machadoDeAssis.listarEmprestimos();

        // yoda.devolverLivro("Cosmos"); // Cosmos foi emprestado ao Agnácio
        yoda.devolverLivro("100 endgames you must know");
        machadoDeAssis.listarLivrosDisponiveis();
        machadoDeAssis.listarLivrosEmprestados();
        yoda.listarLivros();

    }

}