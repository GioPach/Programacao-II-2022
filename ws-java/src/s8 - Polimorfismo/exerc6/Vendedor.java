package exerc6;

import exerc3.Empregado;
import utils.Validador;

/**
 * Implemente a classe Vendedor como subclasse
 * da classe Empregado. Um determinado vendedor
 * tem como atributos, para além dos atributos
 * da classe Pessoa e da classe Empregado,
 * o atributo valorVendas (correspondente ao valor monetário dos artigos
 * vendidos)
 * o atributo comissao (porcentagem do valorVendas que será adicionado ao
 * vencimento base do Vendedor).
 * 
 * Note que deverá redefinir nesta subclasse
 * o método herdado calcularSalario (o salário
 * de um vendedor é equivalente ao salário de
 * um empregado usual acrescido da referida
 * comissão).
 */

public class Vendedor extends Empregado {

    private double valorVendas;
    private double comissao;

    public Vendedor() {
    }

    public Vendedor(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double imposto,
            double valorVendas, double comissao) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        setValorVendas(valorVendas);
        setComissao(comissao);
    }

    public double getValorVendas() {
        return this.valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        if (Validador.validarNumeroNatural(valorVendas)) {
            this.valorVendas = valorVendas;
        } else {
            throw new Error("Classe Valor Vendas: valor de vendas inválido...menor que 0.");
        }
    }

    public double getComissao() {
        return this.comissao;
    }

    public void setComissao(double comissao) {
        if (Validador.validarPorcentagem(comissao)) {
            this.comissao = comissao;
        } else {
            throw new Error("Classe Vendedor: comissão inválida...");
        }
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() - getSalarioBase() * getImposto() + this.valorVendas * this.comissao;
    }

    @Override
    public String toString() {
        return " valorVendas='" + getValorVendas() + "'" +
                ", comissao='" + getComissao() + "'";
    }

}
