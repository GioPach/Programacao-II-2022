package exerc1.classes;

import utils.*;

public class Emprestimo {

    private int id;
    private Pessoa receptor;
    private Livro livroEmprestado;
    private Data dataEmprestimo;
    private Data dataDevolucao;

    public Emprestimo(Pessoa receptor, Livro livroEmprestado, Data dataEmprestimo, Data dataDevolucao) {
        this.receptor = receptor;
        this.livroEmprestado = livroEmprestado;
        this.dataEmprestimo = Data.validarData(dataEmprestimo);
        this.dataDevolucao = Data.validarData(dataDevolucao);
    }

    public int getId() {
        return this.id;
    }

    public Pessoa getReceptor() {
        return this.receptor;
    }

    public Livro getLivro() {
        return this.livroEmprestado;
    }

    public Data getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public Data getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setReceptor(Pessoa receptor) {
        this.receptor = receptor;
    }

    public void setLivro(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }

    public void setDataEmprestimo(Data dataEmprestimo) {
        this.dataEmprestimo = Data.validarData(dataEmprestimo);
    }

    public void setDataDevolucao(Data dataDevolucao) {
        this.dataDevolucao = Data.validarData(dataDevolucao);
    }   

}