import java.time.LocalDate;

public class Aluno {

    protected String nome;
    protected DateType dataNascimento;
    protected double[] notas;

    public Aluno(String nome, DateType dataNascimento, double[] notas) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.notas = notas;
    }

    public double calcularMediaNotas() {
        double soma = 0.0;
        for (double nota : this.notas) soma += nota;
        return soma / this.notas.length; 
    }

    public int calcularIdade() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - dataNascimento.ano;
    }

}