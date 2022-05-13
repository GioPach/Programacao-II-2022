package exerc2.classes;

import utils.VerificadorValidade;

public class Contato {

    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = VerificadorValidade.validarNome(nome);
        this.telefone = VerificadorValidade.validarTelefone(telefone);
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome) {
        this.nome = VerificadorValidade.validarNome(nome);
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}