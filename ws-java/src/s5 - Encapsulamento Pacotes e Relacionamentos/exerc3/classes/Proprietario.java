package exerc3.classes;

import utils.*;

public class Proprietario {

    final private String nome;
    final private String cpf;
    private Carro carro;
    private String telefone;

    public Proprietario(String nome, String cpf, String telefone) {
        this.nome = VerificadorValidade.validarNome(nome);
        this.cpf = VerificadorValidade.validarCpf(cpf);
        this.telefone = VerificadorValidade.validarTelefone(telefone);
    }
    
    public String getNome() {
        return this.nome;
    }

    public Carro getCarro() {
        return this.carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = VerificadorValidade.validarTelefone(telefone);
    }

}