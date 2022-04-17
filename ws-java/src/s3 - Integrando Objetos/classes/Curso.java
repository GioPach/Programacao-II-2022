package classes;

import uteis.Comparators.*;
import java.util.SortedSet;
import java.util.TreeSet;

public class Curso {

    private String nome;
    private String coordenador;

    private SortedSet<Turma> turmas = new TreeSet<Turma>(new TurmaComparator());
    private SortedSet<Professor> professores = new TreeSet<Professor>(new ProfessorComparator());
    private SortedSet<Aluno> alunos = new TreeSet<Aluno>(new AlunoComparator());
    private SortedSet<Aluno> alunosEgressos = new TreeSet<Aluno>(new AlunoComparator());
    private SortedSet<Aluno> alunosCancelados = new TreeSet<Aluno>(new AlunoComparator());

    public Curso(String nome, String coordenador, Turma[] turmas, Aluno[] alunosEgressos) {
        this.nome = nome;
        this.coordenador = coordenador;

        for (Turma turma : turmas) {
            this.turmas.add(turma);
            for (Aluno aluno : turma.getAlunos())
                this.alunos.add(aluno);
            for (Professor professor : turma.getProfessores()) 
                this.professores.add(professor);
            
        }
            
        for (Aluno alunoEgresso : alunosEgressos)
            this.alunosEgressos.add(alunoEgresso);
        
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getCoordenador() {
        return this.coordenador;
    }

    public SortedSet<Turma> getTurmas() {
        return this.turmas;
    }

    public Turma getTurma(String nomeTurma) {
        for (Turma turma : this.turmas) {
            if (turma.getNome() == nomeTurma)
                return turma;
        }
        return null; 
    }

    public void listarAlunosMatriculados() {   
        System.out.println("=================== Alunos Matriculados ===================");
        for (Aluno aluno : this.alunos)
            System.out.format("\tNome: %s\n", aluno.getNome());
    }

    public void listarAlunosEgressos() {
        System.out.println("===================== Alunos Egressos =====================");
        for (Aluno alunoEgresso : this.alunosEgressos)
            System.out.format("\tNome: %s\n", alunoEgresso.getNome());
    }
    
    public void listarAlunosCancelados() {       
        System.out.println("==================== Alunos Cancelados ====================");
        for (Aluno alunoCancelado : this.alunosCancelados) 
            System.out.format("\tNome: %s\n", alunoCancelado.getNome());
    }   

    public void listarTodosAlunos() {
        listarAlunosMatriculados();
        listarAlunosEgressos();
        listarAlunosCancelados();
    }

    public void listarProfessores() {
        System.out.println("==================== Professores Ativos ====================");
        for (Professor professor : this.professores) 
             System.out.format("\tNome: %s\n", professor.getNome());
        
    }

    public void listarTurmas() {
        System.out.println("================ Turmas ================");
        for (Turma turma : this.turmas) 
             System.out.format("Turma: %s\n", turma.getNome());
        
    }

    public Aluno matricularAluno(Aluno aluno) {
        this.alunos.add(aluno);

        return aluno;
    }

    public Professor contratarProfessor(Professor professor) {
        this.professores.add(professor);
        return professor;
    }

    private Aluno encontrarAlunoMatriculado(String matricula, String nomeAluno) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getNome().compareTo(nomeAluno) == 0) {
                if (aluno.getMatricula().compareTo(matricula) == 0) {
                    return aluno;
                }
            }
        }
        return null;
    }

    private boolean encontrarAlunoEgresso(String nomeAluno, String matricula) {
        for (Aluno aluno : this.alunosEgressos) {
            if (aluno.getNome().compareTo(nomeAluno) == 0) {
                if (aluno.getMatricula().compareTo(matricula) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean encontrarAlunoCancelado(String nomeAluno, String matricula) {
        for (Aluno aluno : this.alunosCancelados) {
            if (aluno.getNome() == nomeAluno) {
                if (aluno.getMatricula() == matricula) {
                    return true;
                }
            }
        }
        return false;
    }

    private Aluno removerAlunoDaTurma(String nomeAluno, String matricula) {
        Aluno cancelado = encontrarAlunoMatriculado(nomeAluno, matricula);
        if (cancelado == null)
            throw new Error("Aluno a ser modificado não está matriculado...");

        for (Turma turma : this.turmas) {
            if (turma.getNome().compareTo(cancelado.getNomeTurma()) == 0) {
                turma.removerAluno(cancelado);
                break;
            }
        }
        return cancelado;
    }

    private Aluno removerAlunoDoCurso(Aluno alunoCancelado) {
        this.alunosCancelados.add(new Aluno(alunoCancelado.getNome(), alunoCancelado.getNotas()));
        this.alunos.remove(alunoCancelado);

        return alunoCancelado;
    }
    
    public Aluno tornarAlunoEgresso(String nomeAluno, String matricula) {
        if (encontrarAlunoEgresso(nomeAluno, matricula)) return null;
            
        Aluno egresso = removerAlunoDaTurma(nomeAluno, matricula);
        this.alunosEgressos.add(new Aluno(egresso.getNome(), egresso.getNotas()));
        this.alunos.remove(egresso);
        return egresso;
            
    }
    
    public Aluno cancelarAluno(String nomeAluno, String matricula) {
        if (encontrarAlunoCancelado(nomeAluno, matricula)) return null;

        Aluno cancelado = removerAlunoDaTurma(nomeAluno, matricula);
        return removerAlunoDoCurso(cancelado);
        
    }
        
}