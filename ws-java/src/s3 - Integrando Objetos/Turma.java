import java.util.*;

public class Turma {

    protected List<Aluno> alunos = new ArrayList<Aluno>();
    protected Professor professor;
    protected String disciplina;

    public Turma(List<Aluno> alunos, Professor professor, String disciplina) {
        this.alunos = alunos;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public void matricular(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void imprimirAlunosENotas() {

        Map<String, double[]> alunosNotas = new HashMap<String, double[]>();
        for(Aluno aluno : this.alunos) {
            alunosNotas.put(aluno.nome, aluno.notas);
        }

        for(String nome : alunosNotas.keySet()) {
            System.out.format("%s | Notas: ", nome);

            for(double notas : alunosNotas.get(nome)) {
                System.out.format("%f", notas);
            }
            System.out.print("\n");
        }

    }
        
}