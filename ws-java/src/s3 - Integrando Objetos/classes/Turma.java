package classes;

import uteis.Comparators.*;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.TreeMap;

public class Turma {

    public String nome;
    protected SortedSet<Aluno> alunos = new TreeSet<Aluno>(new AlunoComparator());
    protected SortedSet<Professor> professores = new TreeSet<Professor>(new ProfessorComparator());
    protected SortedSet<String> disciplinas = new TreeSet<String>();

    public Turma(String nome, Aluno[] alunos, Professor[] professores, String[] disciplinas) {
        this.nome = nome;
        for (Aluno aluno : alunos)
            this.alunos.add(aluno);
        for (Professor professor : professores)
            this.professores.add(professor);
        for (String disciplina : disciplinas)
            this.disciplinas.add(disciplina);
    }

    public String getNome() {
        return this.nome;
    }
    
    public SortedSet<Aluno> getAlunos() {
       return this.alunos;
    }

    public SortedSet<Professor> getProfessores() {
        return this.professores;
    }

    public SortedSet<String> getDisciplinas() {
        return this.disciplinas;
    }

    public void matricularAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public void adicionarDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplina(String disciplina) {
        if (!this.disciplinas.contains(disciplina))
            return;

        this.disciplinas.remove(disciplina);
    }

    public void imprimirProfessoresEDisciplinas() {
        TreeMap<String, SortedSet<String>> professoresDisciplinas = new TreeMap<String, SortedSet<String>>();
        for (Professor professor : this.getProfessores()) 
            professoresDisciplinas.put(professor.getNome(), professor.getDisciplinas());

        System.out.println("================ Professores e Disciplinas ================");
        for (String nome : professoresDisciplinas.keySet()) {
            System.out.format("Nome: %s\t|   Disciplina(s): %s\n", nome, professoresDisciplinas.get(nome));
        }

    }

    public void imprimirAlunosENotas() {
        TreeMap<String, double[]> alunosNotas = new TreeMap<String, double[]>();
        for (Aluno aluno : this.alunos) 
            alunosNotas.put(aluno.getNome(), aluno.getNotas());

        System.out.println("================ Alunos e Notas ================");
        for (String nome : alunosNotas.keySet()) {
            System.out.format("Nome: %s\t|   Notas: ", nome);

            for (double nota : alunosNotas.get(nome)) 
                System.out.format("%.1f ", nota);
            
            System.out.println();
        }

    }
    
    public void imprimirAlunosEMedias() {
        TreeMap<String, Double> alunosMedias = new TreeMap<String, Double>();
        for (Aluno aluno : this.alunos)
            alunosMedias.put(aluno.getNome(), aluno.calcularMediaNotas());

        System.out.println("================ Alunos e Médias ================");
        for (String nome : alunosMedias.keySet())
            System.out.format("Nome: %s\t|   Média: %.1f\n", nome, alunosMedias.get(nome));

    }
    
    public void imprimirAlunosEIdades() {
        TreeMap<String, Integer> alunosIdades = new TreeMap<String, Integer>();
        for (Aluno aluno : this.alunos)
            alunosIdades.put(aluno.getNome(), aluno.calcularIdade());

        System.out.println("================ Alunos e Idades ================");
        for (String nome : alunosIdades.keySet()) 
            System.out.format("Nome: %s\t|   Idade: %d anos\n", nome, alunosIdades.get(nome));
    }
        
}