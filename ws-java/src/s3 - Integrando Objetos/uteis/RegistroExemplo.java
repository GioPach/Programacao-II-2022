package uteis;

import classes.*;
import java.util.SortedSet;
import java.util.TreeSet;

public class RegistroExemplo {

    private Aluno[] registrarAlunosExemplo() {

        Aluno[] alunos = new Aluno[15];

        alunos[0] = new Aluno("2150", "André", new DateType(1, 2, 2004), new double[]{7.5, 6.4, 5.6, 9.2, 8.9});
        alunos[1] = new Aluno("2150", "Bianca", new DateType(3, 4, 2003), new double[]{7.3, 5.2, 6.9, 8.4, 8.6});
        alunos[2] = new Aluno("2150", "Carla", new DateType(7, 2, 2003), new double[]{9.6, 8.2, 9.4, 9.3, 10.0});
        alunos[3] = new Aluno("2150", "Dagoberto", new DateType(9, 9, 2004), new double[]{5.6, 6.5, 6.3, 7.2, 7.1});
        alunos[4] = new Aluno("2150", "Eduardo", new DateType(10, 6, 2003), new double[]{9.6, 9.2, 8.7, 8.3, 8.9});
        alunos[5] = new Aluno("2150", "Fábio", new DateType(15, 4, 2003), new double[]{7.6, 6.7, 7.8, 8.9, 9.2});
        alunos[6] = new Aluno("2150", "Gabriela", new DateType(20, 5, 2003), new double[]{7.3, 7.5, 7.5, 8.5, 9.0});
        alunos[7] = new Aluno("2150", "Giovani", new DateType(16, 5, 2003), new double[]{7.6, 8.2, 8.3, 8.5, 8.9});
        alunos[8] = new Aluno("2150", "Heitor", new DateType(5, 7, 2003), new double[]{8.5, 8.7, 8.5, 8.6, 8.2});
        alunos[9] = new Aluno("2150", "Irineu", new DateType(9, 10, 2003), new double[]{9.2, 9.3, 9.4, 9.5, 9.6});
        alunos[10] = new Aluno("2150", "Jorel", new DateType(23, 2, 2003), new double[]{10.0, 10.0, 9.9, 9.8, 9.8});
        alunos[11] = new Aluno("2150", "Katielly", new DateType(4, 7, 2003), new double[]{7.8, 7.9, 7.9, 8.0, 6.5});
        alunos[12] = new Aluno("2150", "Lucíola", new DateType(15, 5, 2003), new double[]{9.2, 9.3, 9.6, 9.5, 9.1});
        alunos[13] = new Aluno("2150", "Morrice", new DateType(17, 2, 2003), new double[]{5.6, 7.2, 7.5, 7.5, 7.4});
        alunos[14] = new Aluno("2150", "Norma", new DateType(20, 3, 2003), new double[]{6.7, 6.8, 6.7, 7.2, 7.5});

        return alunos;

    }

    private Aluno[] registrarAlunosEgressosExemplo() {

        Aluno[] alunosEgressos = new Aluno[4];

        alunosEgressos[0] = new Aluno("Joel", new DateType(3, 2, 2003), new double[] { 9.6, 9.2, 8.7, 8.3, 8.9 });
        alunosEgressos[1] = new Aluno("Godofredo", new DateType(5, 6, 2004), new double[] { 9.6, 8.2, 9.4, 9.3, 10.0 });
        alunosEgressos[2] = new Aluno("Agnácio", new DateType(15, 4, 2004), new double[] { 7.3, 5.2, 6.9, 8.4, 8.6 });
        alunosEgressos[3] = new Aluno("Nastácia", new DateType(19, 11, 2003), new double[] { 9.6, 8.5, 8.9, 9.2, 9.5 });

        return alunosEgressos;

    }
    
    private Professor[] registrarProfessoresExemplo() {

        Professor[] professores = new Professor[3];

        professores[0] = new Professor("Márcio", "Integral",
                new String[] { "Programação 2", "Programação Orientada a Objetos" });
        professores[1] = new Professor("Róger", "Integral",
                new String[] { "Engenharia de Software 1", "Programação 1" });
        professores[2] = new Professor("Juliana", "Integral",
                new String[] { "Banco de Dados 1", "Administração de Redes e Serviços" });

        return professores;
    }
    
    public String[] extrairDisciplinas(Professor[] professores) {
        SortedSet<String> disciplinas = new TreeSet<String>();

        for (Professor professor : professores) {
            for (String disciplina : professor.getDisciplinas())
                disciplinas.add(disciplina);
        }

        return disciplinas.toArray(new String[disciplinas.size()]);
    }
    
    private void imprimirAlunosExemplo(Aluno[] alunosMatriculados, Aluno[] alunosEgressos) {
        System.out.println("\n************************************************************");
        System.out.println("=============== Alunos Matriculados: Exemplo ===============");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println(String.format("\tNome: %s\t|   Matrícula: %s", aluno.getNome(), aluno.getMatricula()));
        }
        System.out.println("================= Alunos Egressos: Exemplo =================");
        for (Aluno aluno : alunosEgressos) {
            System.out.println(String.format("\t\tNome: %s", aluno.getNome()));
        }
        System.out.println("============================================================");
        System.out.println("************************************************************\n\n");

    }

    public Curso iniciarCursoExemplo() {

        Aluno[] alunos = registrarAlunosExemplo();
        Professor[] professores = registrarProfessoresExemplo();  
        String[] disciplinas = extrairDisciplinas(professores);
        
        Turma ds3 = new Turma("DS3", alunos, professores, disciplinas);
        Aluno[] alunosEgressos = registrarAlunosEgressosExemplo();

        Turma[] turmas = new Turma[]{ds3};
        Curso ds = new Curso("Desenvolvimento de Sistemas", "Dolurdes", turmas, alunosEgressos);

        imprimirAlunosExemplo(alunos, alunosEgressos);
        return ds;

    }

}