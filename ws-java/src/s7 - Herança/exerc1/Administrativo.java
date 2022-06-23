package exerc1;

import exerc1.enums.Turno;

public class Administrativo extends Assistente {

    private Turno turno;
    private Turno turnoAdicional = Turno.NOTURNO;

    public Administrativo() {

    }

    public Administrativo(String nome, String departamento, double salario, String matricula, Turno turno) {
        super(nome, "Assistente Administrativo", departamento, salario, matricula);
        this.turno = turno;
    }

    public Turno getTurno() {
        return this.turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Turno getTurnoAdicional() {
        return this.turnoAdicional;
    }

    public void setTurnoAdicional(Turno turnoAdicional) {
        this.turnoAdicional = turnoAdicional;
    }

    public void exibeDados() {
        System.out.println("{" +
                " nome='" + getNome() + "'" +
                ", matricula='" + getMatricula() + "'" +
                ", cargo='" + getCargo() + "'" +
                ", departamento='" + getDepartamento() + "'" +
                ", salario='" + getSalario() + "'" +
                ", acréscimo salarial='" + getAcrescimoSalario() + "'" +
                ", turno='" + getTurno() + "'" +
                ", turno adicional='" + getTurnoAdicional() + "'" +
                "}");
    }

}
