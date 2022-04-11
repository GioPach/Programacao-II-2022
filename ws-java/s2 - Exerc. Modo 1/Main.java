import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        List<Double> notas = new ArrayList<Double>();
        notas.addAll(Arrays.asList(8.5, 8.3, 8.5, 9.5));

        Aluno aluno = new Aluno("Dagoberto Silveira", 1244, notas);
        
        aluno.adicionarNota(8.9);
        aluno.alterarMatricula(34576);

        System.out.println(aluno.getMatricula());
        System.out.println(aluno.getNotas());
        System.out.println(aluno.getNome());
        aluno.calcularMedia();
    }

}
