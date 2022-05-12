package exerc1.classes;

import java.util.Set;

import utils.*;

import java.util.HashSet;

public class Biblioteca {

    private static int sequenciaIdAssociados = 0;
    private static int sequenciaIdLivros = 0;
    private static int sequenciaIdEmprestimos = 0;
    
    private Set<Pessoa> associados = new HashSet<Pessoa>();
    private Set<Livro> livrosDisponiveis = new HashSet<Livro>();
    private Set<Livro> livrosEmprestados = new HashSet<Livro>();
    private Set<Emprestimo> emprestimos = new HashSet<Emprestimo>();

    /**************** Construtoras ****************/

    public Biblioteca(Set<Pessoa> associados, Set<Livro> livrosDisponiveis) {
        for (Pessoa associado : associados) {
            associado.id = sequenciaIdAssociados++;
        }
        this.associados = associados;
        
        for (Livro livro : livrosDisponiveis) {
            livro.id = sequenciaIdLivros++;
        }
        this.livrosDisponiveis = livrosDisponiveis;
    }

    /**************** Getters ****************/

    public Set<Pessoa> getAssociados() {
        return this.associados;
    }

    public Pessoa getAssociado(int id) {
        for(Pessoa associado : this.associados) {
            if(associado.getId() == id) return associado;
        }
        return null;
    }

    public Livro getLivroDisponivel(String nome, String autor) {
        for(Livro livro : this.livrosDisponiveis) {
            if(livro.getNome().equalsIgnoreCase(nome)) {
                if(livro.getAutor().equalsIgnoreCase(autor)) {
                    return livro;
                }
            }
        }
        //caso não encontre:
        System.out.println("Não foi possível encontrar o livro especificado.");
        return null;
    }

    public Set<Livro> getLivrosDisponiveis() {
        return this.livrosDisponiveis;
    }

    public Set<Livro> getLivrosEmprestados() {
        return this.livrosEmprestados;
    }

    public Set<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    /**************** Métodos ****************/

    //* Associados

    public void addAssociado(Pessoa associado) {
        associado.setId(this.associados.size()); //obter ultima posição + 1
        this.associados.add(associado);
    }

    public void removerAssociado(Pessoa associado) {
        this.associados.remove(associado);
    }

    public void imprimirAssociados() {
        System.out.println("\n=-=-=-=-=-=-=-=-=- Associdos =-=-=-=-=-=-=-=-=-");
        for(Pessoa associado : this.associados) System.out.format("ID: %d |\tNome: %s\n", associado.getId(), associado.getNome());
        System.out.println();
    }

    //* Livros

    public void imprimirLivrosDisponiveis() {
        System.out.println("\n=-=-=-=- Livros Disponíveis =-=-=-=-");
        for(Livro livro : this.livrosDisponiveis) System.out.format("ID: %d |\tNome: %s\n", livro.getId(), livro.getNome());
        System.out.println();
    }

    public void imprimirLivrosEmprestados() {
        System.out.println("\n=-=-=-=- Livros Emprestados =-=-=-=-");
        for(Livro livro : this.livrosEmprestados) System.out.format("ID: %d |\tNome: %s\n", livro.getId(), livro.getNome());
        System.out.println();
    }

    public void addLivro(Livro livro) {
        livro.setId(this.livrosDisponiveis.size()); //obter ultima posição + 1
        this.livrosDisponiveis.add(livro);
    }

    public void removerLivro(String nomeLivro) {
        for (Livro livro : this.livrosDisponiveis) {
            if (livro.getNome().equalsIgnoreCase(nomeLivro)) {
                this.livrosDisponiveis.remove(livro);
                break;
            }
        }
    }

    private void moverLivroEmprestado(Livro livroEmprestimo) {
        this.livrosEmprestados.add(livroEmprestimo);
        this.livrosDisponiveis.remove(livroEmprestimo);
    }

    private void moverLivroDevolvido(Livro livroDevolvido) {
        this.livrosDisponiveis.add(livroDevolvido);
        this.livrosEmprestados.remove(livroDevolvido);
    } 
    
    //* Criar empréstimo

    public void imprimirEmprestimos() {
        
        System.out.println("=-=-=-=-=-=-= Empréstimos =-=-=-=-=-=-=\n");
        for(Emprestimo emprestimo : this.emprestimos) {
            System.out.format("* Código do empréstimo: %d\n", emprestimo.getId());
            System.out.format("Receptor: %s | Título do livro: %s | Autor do livro: %s\n", 
                emprestimo.getReceptor().getNome(), emprestimo.getLivro().getNome(), emprestimo.getLivro().getAutor());
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }

    private Data definirDataDevolucao(Data dataEmprestimo) {        
        return Data.calcularIntervaloDias(dataEmprestimo, 7);        
    }

    private Livro encontrarLivro(Livro livroSolicitado) {
        
        for (Livro livro : this.livrosDisponiveis) {
            if (livro.getNome().equalsIgnoreCase(livroSolicitado.getNome())) {
                if (livro.getAutor().equalsIgnoreCase(livroSolicitado.getAutor())) {
                    moverLivroEmprestado(livroSolicitado);
                    return livro;
                }
            }
        }

        return null;

    }

    private void concluirEmprestimo(Pessoa receptor, Livro livroSolicitado) {
        final Data dataEmprestimo = Data.obterDataAtual();
        final Emprestimo emprestimo = new Emprestimo(receptor, livroSolicitado, dataEmprestimo, definirDataDevolucao(dataEmprestimo));
        
        emprestimo.setId(sequenciaIdEmprestimos++);
        this.emprestimos.add(emprestimo);         
    }

    public Livro emprestimoLivro(Pessoa receptor, Livro livroSolicitado) {

        Livro livroEmprestimo = encontrarLivro(livroSolicitado);

        if (livroEmprestimo != null) {
            concluirEmprestimo(receptor, livroSolicitado);
            System.out.println("\nEmpréstimo realizado com sucesso.");
        } 
        else {
            System.out.println("O livro solicitado não foi encontrado...");
        }

        return livroEmprestimo;
    }

    //* Fechar Empréstimo
    
    private Pessoa validarReceptor(Pessoa receptor) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getReceptor().getNome().equalsIgnoreCase(receptor.getNome())) {
                if (emprestimo.getReceptor().getId() == receptor.getId()) {
                    return receptor;
                }
            }
        }
        return null;
    }
    
    private Livro validarLivroEmprestado(Livro livroEmprestado) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getLivro().getNome().equalsIgnoreCase(livroEmprestado.getNome())) {
                if (emprestimo.getLivro().getAutor().equalsIgnoreCase(livroEmprestado.getAutor())) {
                    if (emprestimo.getLivro().getId() == livroEmprestado.getId()) {
                        return livroEmprestado;
                    }
                }
            }
        }
        return null;
    }
    
    public void fecharEmprestimo(Pessoa receptor, Livro livroEmprestado) {

        receptor = validarReceptor(receptor);
        livroEmprestado = validarLivroEmprestado(livroEmprestado);
        
        if (receptor == null || livroEmprestado == null) {
            System.out.format("\nNão foi possível identificar o empréstimo => Receptor: %s | Livro: %s \n",
                    receptor.getNome(), livroEmprestado.getNome());
            return;
        }

        moverLivroDevolvido(livroEmprestado);
        System.out.println("Livro devolvido.");

    }

}   
