package exerc1;

public class Tecnico extends Assistente {

    final private double bonusSalarial = 1350.0;

    public Tecnico() {
    }

    public Tecnico(String nome, String departamento, double salarioBase, String matricula) {
        super(nome, "Assistente Técnico", departamento, salarioBase, matricula);
        super.setAcrescimoSalario(bonusSalarial);
    }

}
