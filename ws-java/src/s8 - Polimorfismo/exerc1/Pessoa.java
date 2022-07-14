package exerc1;

import utils.Validador;

/**
 * Cria uma Classe Pessoa, contendo os atributos 
 * encapsulados, com seus respectivos seletores 
 * (getters) e modificadores (setters), e ainda o 
 * construtor padrão e pelo menos mais duas opções 
 * de construtores conforme sua percepção. Atributos: 
 * String nome; String endereço; String telefone;
 */

public class Pessoa {

    private String nome;
    private String endereco;
    private String telefone;


    public Pessoa() {
    }

    public Pessoa(String nome, String endereco, String telefone) {
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(Validador.validarNome(nome)) {
            this.nome = nome;
        } else {
            throw new Error("Superclasse Pessoa: nome inválido...");
        }
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        if(Validador.validarTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new Error("Superclasse Pessoa: telefone inválido...");
        }
    }

    public Pessoa nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Pessoa endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public Pessoa telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public String toString() {
        return 
            " nome='" + getNome() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", telefone='" + getTelefone() + "'";
    }


}