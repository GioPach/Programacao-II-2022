package exerc3;

import exerc1.Pessoa;
import utils.Validador;

/**
 * Considere, como subclasse da classe Pessoa, a classe
 * Empregado. Considere que cada instância da classe
 * Empregado tem, para além dos atributos que caracterizam
 * a classe Pessoa, os atributos codigoSetor (inteiro),
 * salarioBase (vencimento base) e imposto (porcentagem
 * retida dos impostos). Implemente a classe Empregado
 * com métodos seletores e modificadores e um método
 * calcularSalario. Escreva um programa de teste adequado
 * para a classe Empregado.
 */

public class Empregado extends Pessoa {

    private int codigoSetor;
    private double salarioBase;
    private double imposto;

    public Empregado() {
    }

    public Empregado(String nome, String endereco, String telefone, int codigoSetor, double salarioBase,
            double imposto) {
        super(nome, endereco, telefone);
        setCodigoSetor(codigoSetor);
        setSalarioBase(salarioBase);
        setImposto(imposto);
    }

    public Empregado(int codigoSetor, double salarioBase, double imposto) {
        setCodigoSetor(codigoSetor);
        setSalarioBase(salarioBase);
        setImposto(imposto);
    }

    public int getCodigoSetor() {
        return this.codigoSetor;
    }

    public void setCodigoSetor(int codigoSetor) {
        if (Validador.validarNumeroNatural(codigoSetor)) {
            this.codigoSetor = codigoSetor;
        } else {
            throw new Error("Superclasse Empregado: código de setor inválido...");
        }
    }

    public double getSalarioBase() {
        return this.salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        if (Validador.validarPorcentagem(imposto)) {
            this.imposto = imposto;
        } else {
            throw new Error("Classe Empregado: porcentagem inválida...");
        }
    }

    public double calcularSalario() {
        return this.salarioBase - this.salarioBase * imposto;
    }

    @Override
    public String toString() {
        return " codigoSetor='" + getCodigoSetor() + "'" +
                ", salarioBase='" + getSalarioBase() + "'" +
                ", imposto='" + getImposto() + "'";
    }

}