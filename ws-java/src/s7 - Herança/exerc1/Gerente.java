package exerc1;

public class Gerente extends Funcionario {

    final double acrescimoSalarial = 0.4;

    public Gerente() {
    }

    public Gerente(String nome, String departamento, double salarioBase) {
        super(nome, "Gerente", departamento, salarioBase);
        super.setAcrescimoSalario(acrescimoSalarial);
    }

    public void gerenciar() {
        System.out.println("Gerenciando...");
    }

}