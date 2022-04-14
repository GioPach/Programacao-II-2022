import java.time.LocalDate;

public class Aluno {

    protected String nome;
    protected DateType dataNascimento;
    protected double[] notas = new double[5];

    public Aluno(String nome, DateType dataNascimento, double[] notas) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        
        if (notas.length < 5)
            throw new Error("Devem ser passadas 5 notas...");
        for (double nota : notas) {
            if (nota < 0 || nota > 10)
                throw new Error("Nota informada inválida...");
        }
        this.notas = notas;
    }

    public double calcularMediaNotas() {
        double soma = 0.0;
        for (double nota : this.notas)
            soma += nota;
        return soma / this.notas.length;
    }

    private int calcularAjusteDia(int diaAtual) {
        if (this.dataNascimento.dia - diaAtual <= 0)
            return 0;
        else
            return -1;
    }
    
    private int calcularAjuste(LocalDate dataAtual) {
        if (this.dataNascimento.mes - dataAtual.getMonthValue() < 0)
            return 0;
        else if (this.dataNascimento.mes - dataAtual.getMonthValue() == 0)
            return calcularAjusteDia(dataAtual.getDayOfMonth());
        else 
            return -1;        
    }

    public int calcularIdade() {
        LocalDate currentDate = LocalDate.now();
        int idade = currentDate.getYear() - this.dataNascimento.ano;

        return idade + calcularAjuste(currentDate);

    }

}