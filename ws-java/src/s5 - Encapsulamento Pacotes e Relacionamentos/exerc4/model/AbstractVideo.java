package exerc4.model;

import exerc4.classes.Lancamentos;
import utils.*;

public class AbstractVideo {

    final private String nome;
    final private String diretor;
    final private String genero;
    final private Data dataLancamento;
    private boolean isLancamento;

    public AbstractVideo(String nome, String diretor, String genero, Data dataLancamento) {
        this.nome = nome;
        this.diretor = VerificadorValidade.validarNome(diretor);
        this.genero = VerificadorValidade.validarNome(genero);
        this.dataLancamento = Data.validarData(dataLancamento);
        this.isLancamento = Lancamentos.isLancamento(dataLancamento);
    }

    public String getNome() {
        return this.nome;
    }

    public String getDiretor() {
        return this.diretor;
    }

    public String getGenero() {
        return this.genero;
    }

    public Data getDataLancamento() {
        return this.dataLancamento;
    }

    public boolean getIsLancamento() {
        return this.isLancamento;
    }

    public void setIsLancamento(boolean isLancamento) {
        this.isLancamento = isLancamento;
    }

}
