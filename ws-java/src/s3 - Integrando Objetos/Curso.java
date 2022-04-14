import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Curso {

    private String nome;
    private String coordenador;
    private Set<Professor> professores = new HashSet<Professor>();
    private Set<Turma> turmas = new HashSet<Turma>();
    private Set<Aluno> alunosEgressos = new HashSet<Aluno>();
    private Set<Aluno> alunosCancelados = new HashSet<Aluno>();
     
    public Curso(String nome, String coordenador, Turma[] turmas, Aluno[] alunosEgressos) {
        this.nome = nome;
        this.coordenador = coordenador;
        for (Turma turma : turmas)
            this.turmas.add(turma);
        for (Aluno aluno : alunosEgressos)
            this.alunosEgressos.add(aluno);

    }
    
    private void listarAlunosMatriculados() {
        for (Turma turma : this.turmas) {
            System.out.println(turma.getAlunos());
        }
    }

    private void listarAlunosEgressos() {

    }
    
    private void listarAlunosCancelados() {

    }

    public void listarAlunos() {
        listarAlunosMatriculados();
        listarAlunosEgressos();
        listarAlunosCancelados();
    }

    public void listarProfessores() {
        for (Turma turma : this.turmas) {
            System.out.println(turma.getProfessores());
        }
    }

    public void matricularAluno(Aluno aluno) {

    }

    public void tornarAlunoEgresso(Aluno aluno) {

    }
    
    public void excluirAluno(Aluno aluno) {

    }

}