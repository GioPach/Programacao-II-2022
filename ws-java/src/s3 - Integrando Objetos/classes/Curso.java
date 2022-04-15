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
        return new Turma("Undefined"); 
    }

    public void listarAlunosMatriculados() {
        System.out.println("================ Alunos Matriculados ================");
        for (Aluno aluno : this.alunos)
            System.out.format("Nome: %s\n", aluno.getNome());
    }

    public void listarAlunosEgressos() {
        System.out.println("================ Alunos Egressos ================");
        for (Aluno alunoEgresso : this.alunosEgressos) 
            System.out.format("Nome: %s\n", alunoEgresso.getNome());
    }
    
    public void listarAlunosCancelados() {       
        System.out.println("================ Alunos Cancelados ================");
        for (Aluno alunoCancelado : this.alunosCancelados) 
            System.out.format("Nome: %s\n", alunoCancelado.getNome());
    }   

    public void listarTodosAlunos() {
        listarAlunosMatriculados();
        listarAlunosEgressos();
        listarAlunosCancelados();
    }

    public void listarProfessores() {
        System.out.println("================ Professores Ativos ================");
        for (Professor professor : this.professores) 
             System.out.format("Nome: %s\n", professor.getNome());
        
    }

    public void listarTurmas() {
        System.out.println("================ Turmas ================");
        for (Turma turma : this.turmas) 
             System.out.format("Turma: %s\n", turma.getNome());
        
    }

    public Aluno matricularAluno(Aluno aluno) {
        // if(this.alunos.contains(aluno)) return; --> desnecessário (Set<Aluno>)
        this.alunos.add(aluno);
        return aluno;
    }

    public Professor contratarProfessor(Professor professor) {
        this.professores.add(professor);
        return professor;
    }

    private boolean encontrarAlunoMatriculado(String nomeAluno, String matricula) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getNome().compareTo(nomeAluno) == 0) {
                if (aluno.getMatricula().compareTo(matricula) == 0) {
                    return true;
                }
            }
        }
        return false;
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

    public Aluno tornarAlunoEgresso(Aluno aluno) {
        if (encontrarAlunoEgresso(aluno.getNome(), aluno.getMatricula())) return new Aluno("Aluno já egresso");
        if(!encontrarAlunoMatriculado(aluno.getNome(), aluno.getMatricula())) return new Aluno("Aluno não matriculado");
            
        this.alunosEgressos.add(new Aluno('.' + aluno.getNome(), aluno.getMatricula(), aluno.getNotas()));
        this.alunos.remove(aluno);
        return aluno;
            
    }
    
    public Aluno cancelarAluno(Aluno aluno) {
        if (encontrarAlunoCancelado(aluno.getNome(), aluno.getMatricula())) return new Aluno("Aluno já cancelado");
        if(!encontrarAlunoMatriculado(aluno.getNome(), aluno.getMatricula())) return new Aluno("Aluno não matriculado");
           
        this.alunosCancelados.add(new Aluno(aluno.getNome(), aluno.getNotas()));
        this.alunos.remove(aluno);
        return aluno;
    }
        
}