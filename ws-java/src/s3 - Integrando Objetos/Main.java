import uteis.*;
import classes.*;

public class Main {
    public static void main(String[] args) {

        RegistroExemplo rex = new RegistroExemplo();

        Curso ds = rex.iniciarCursoExemplo();

        // ds.listarTodosAlunos();
        // ds.listarTurmas();
        // ds.listarProfessores();
        // Aluno bianca = ds.cancelarAluno(new Aluno("Bianca", "21502"));
        // Aluno dagoberto = ds.tornarAlunoEgresso(new Aluno("Dagoberto", "21504"));
        // Aluno agnacio = ds.matricularAluno(new Aluno("Agnácio", new DateType(3, 5, 2003)));
        // Professor silvio = ds
        //         .contratarProfessor(new Professor("Sílvio", "Integral", new String[] { "Linguagens para Internet" }));
    }

}