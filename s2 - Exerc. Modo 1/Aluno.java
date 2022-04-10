import java.util.List;
import java.util.ArrayList;

/**
 ** Crie uma classe aluno
 ** Crie os atributos: 
 * Nome completo String
 * Matricula - int
 * Notas [5] - array
 ** Crie os métodos:
 * Altera nome
 * Adiciona nota (caso já adicionou todas as notas exiba uma mensagem de erro)
 * Altera matricula
 * Calcula a média
 * 
 * @author Giovani Signori
 * @version 1.0
 */
public class Aluno {

    String nomeCompleto;
    int matricula;
    List<Double> notas = new ArrayList<Double>(5);

    public Aluno(String nomeCompleto, int matricula, List<Double> notas) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.notas = notas;
    }

    public String getNome() {
        return this.nomeCompleto;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public List<Double> getNotas() {
        return this.notas;
    }
    
    public void alterarNome(String novoNome) {
        this.nomeCompleto = novoNome;
    }
    
    public void alterarMatricula(int novaMatricula) {
        this.matricula = novaMatricula;
    }

    public void adicionarNota(double nota) {
        if (this.notas.size() == 5)
            throw new Error("Notas já preenchidas...");
        else
            this.notas.add(nota);
    }

    public void calcularMedia() {
        double soma = 0.0;
        for (double nota : this.notas)
            soma += nota;
        System.out.println(String.format("Média: %.2f", soma / notas.size()));
    }    

}
