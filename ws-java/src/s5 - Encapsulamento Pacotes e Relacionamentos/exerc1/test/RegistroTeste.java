package exerc1.test;

import exerc1.classes.*;
import utils.Data;

import java.util.Set;
import java.util.HashSet;

public class RegistroTeste {
  
    private static Set<Livro> criarLivros() {

        Set<Livro> livrosDisponiveis = new HashSet<Livro>();
        livrosDisponiveis.add(new Livro("Cosmos", "Carl Sagan", "Científico", new Data(1, 1, 1980)));
        livrosDisponiveis.add(new Livro("Codigo Limpo", "Robert C. Martin", "Informática", new Data(8, 9, 2009)));
        livrosDisponiveis.add(new Livro("Um estudo em vermelho", "Sir Arthur Conan Doyle", "Suspense", new Data(1, 6, 1888)));
        livrosDisponiveis.add(new Livro("100 endgames you must know", "Jesus de la Villa", "Xadrez",
                new Data(1, 10, 2016), "New in Chess", 5));
        

        return livrosDisponiveis;
    }

    public static Set<Pessoa> criarPessoas() {

        Set<Pessoa> pessoas = new HashSet<Pessoa>();
        pessoas.add(new Pessoa("Agnácio Mévis", 15));
        pessoas.add(new Pessoa("Joelma Maristela", 18));
        pessoas.add(new Pessoa("Maria Calipso", 23));
        pessoas.add(new Pessoa("Pofendorfi Rodrigues", 56));
        pessoas.add(new Pessoa("Dagoberto Damasceno", 43));
        pessoas.add(new Pessoa("Pedra Pedroso", 72));

        return pessoas;
    }

    public static Biblioteca criarBiblioteca() {

        return new Biblioteca(criarPessoas(), criarLivros());

    }

}
