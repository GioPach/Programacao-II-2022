package exerc2;

import exerc1.Pessoa;

/**
 * Cria uma Classe Pessoa, contendo os atributos 
 * encapsulados, com seus respectivos seletores 
 * (getters) e modificadores (setters), e ainda o 
 * construtor padrão e pelo menos mais duas opções 
 * de construtores conforme sua percepção. Atributos: 
 * String nome; String endereço; String telefone;
 */

public class Fornecedor extends Pessoa {

    private double valorCredito;
    private double valorDivida;
    
    public Fornecedor() {
    }

    public Fornecedor(String nome, String endereco, String telefone, double valorCredito, double valorDivida) {
        super(nome, endereco, telefone);
        setValorCredito(valorCredito);
        setValorDivida(valorDivida);
    }   

    public Fornecedor(double valorCredito, double valorDivida) {
        this.valorCredito = valorCredito;
        this.valorDivida = valorDivida;
    }

    public double getValorCredito() {
        return this.valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorDivida() {
        return this.valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public Fornecedor valorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
        return this;
    }

    public Fornecedor valorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
        return this;
    }

    public double obterSaldo() {
        return this.valorCredito - this.valorDivida;
    }

    @Override
    public String toString() {
        return super.toString() + 
            " valorCredito='" + getValorCredito() + "'" +
            ", valorDivida='" + getValorDivida() + "'";

    }

}