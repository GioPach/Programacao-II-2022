package exerc1;

public class Assistente extends Funcionario {

    private String matricula;

    public Assistente() {

    }

    public Assistente(String nome, String cargo, String departamento, double salario, String matricula) {
        super(nome, cargo, departamento, salario);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void exibeDados() {
        System.out.println("{" +
                " nome='" + getNome() + "'" +
                ", matricula='" + getMatricula() + "'" +
                ", cargo='" + getCargo() + "'" +
                ", departamento='" + getDepartamento() + "'" +
                ", salario='" + getSalario() + "'" +
                ", acréscimo salarial='" + getAcrescimoSalario() + "'" +
                "}");
    }

}