package exerc1;

public class Funcionario {

    private String nome;
    private String cargo;
    private String departamento;
    private double salario;
    private double acrescimoSalarial;

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo, String departamento, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAcrescimoSalario() {
        return this.acrescimoSalarial;
    }

    public void setAcrescimoSalario(double acrescimoSalarial) {
        if (acrescimoSalarial < 0) {
            System.out.println("Acréscimo salarial inválido...");
            return;
        } else if (acrescimoSalarial > 1) {
            // caso receba um valor bruto
            this.salario += acrescimoSalarial;
            this.acrescimoSalarial = acrescimoSalarial / salario;

        } else {
            this.salario += acrescimoSalarial * this.salario;
            this.acrescimoSalarial = acrescimoSalarial;
        }
    }

    public void exibeDados() {
        System.out.println("{" +
                " nome='" + getNome() + "'" +
                ", cargo='" + getCargo() + "'" +
                ", departamento='" + getDepartamento() + "'" +
                ", salario='" + getSalario() + "'" +
                ", acréscimo salarial='" + getAcrescimoSalario() + "'" +
                "}");
    }

}