import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Turma {

    public String nome;
    protected List<Aluno> alunos = new ArrayList<Aluno>();
    protected Map<String, double[]> alunosNotas = new HashMap<String, double[]>();
    protected Professor professor;
    protected List<String> disciplinas = new ArrayList<String>();        

    public Turma(String nome, Aluno[] alunos, Professor professor, String[] disciplinas) {
        this.nome = nome;
        for (Aluno aluno : alunos)
            this.alunos.add(aluno);
        this.professor = professor;
        for (String disciplina : disciplinas)
            this.disciplinas.add(disciplina);

        construirMatrizAlunosNotas();
    }
    
    public String[] getAlunos() {
        List<String> nomesAlunos = new ArrayList<String>();
        for (Aluno aluno : this.alunos) {
            nomesAlunos.add(aluno.nome);
        }
        return nomesAlunos.toArray();
    }

    private void construirMatrizAlunosNotas() {
        for (Aluno aluno : this.alunos) {
            this.alunosNotas.put(aluno.nome, aluno.notas);
        }
    }

    public void matricular(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void adicionarDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplina(String disciplina) {
        if (!this.disciplinas.contains(disciplina))
            return;

        this.disciplinas.remove(disciplina);
    }

    public void imprimirAlunosENotas() {

        for(String nome : this.alunosNotas.keySet()) {
            System.out.format("Nome: %s | Notas: ", nome);

            for(double notas : alunosNotas.get(nome)) {
                System.out.printf(Arrays.toString(notas));
            }
            System.out.println();
        }

    }
        
}