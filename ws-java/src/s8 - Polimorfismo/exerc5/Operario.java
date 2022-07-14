package exerc5;

import exerc3.Empregado;
import utils.Validador;

/**
 * Implemente a classe Operario como subclasse da classe
 * Empregado. Um determinado operário tem como atributos,
 * para além dos atributos da classe Pessoa e da classe
 * Empregado, o atributo valorProducao (que corresponde
 * ao valor monetário dos artigos efetivamente produzidos
 * pelo operário) e comissao (que corresponde à porcentagem
 * do valorProducao que será adicionado ao vencimento base
 * do operário). Note que deverá redefinir nesta subclasse
 * o método herdado calcularSalario (o salário de um
 * operário é equivalente ao salário de um empregado
 * usual acrescido da referida comissão). Escreva um
 * programa de teste adequado para esta classe.
 */

public class Operario extends Empregado {

    private double valorProducao;
    private double comissao;

    public Operario() {

    }

    public Operario(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double imposto,
            double valorProducao, double comissao) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        setValorProducao(valorProducao);
        setComissao(comissao);
    }

    public double getValorProducao() {
        return this.valorProducao;
    }

    public void setValorProducao(double valorProducao) {
        if (Validador.validarNumeroNatural(valorProducao)) {
            this.valorProducao = valorProducao;
        } else {
            throw new Error("Classe Operario: valor de produção inválido...menor que 0.");
        }
    }

    public double getComissao() {
        return this.comissao;
    }

    public void setComissao(double comissao) {
        if (Validador.validarPorcentagem(comissao)) {
            this.comissao = comissao;
        } else {
            throw new Error("Classe Comissao: comissão inválida...");
        }
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + this.valorProducao * this.comissao - getSalarioBase() * getImposto();
    }

}