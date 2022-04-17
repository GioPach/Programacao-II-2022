package classes;

import uteis.DateType;
import java.time.LocalDate;

public class Aluno {

    protected String matricula;
    private static int contadorMatricula = 10;
    protected String nome;
    protected DateType dataNascimento;
    protected double[] notas = new double[5];
    
    public Aluno(String prefixoMatricula, String nome, DateType dataNascimento, double[] notas) { //todo: Inserir alunos de exemplo

        this.matricula = prefixoMatricula + contadorMatricula;
        contadorMatricula++;

        this.nome = nome;
        this.dataNascimento = dataNascimento;

        validarNotasParams(notas);
        this.notas = notas;
    }
    
    public Aluno(String nome, DateType dataNascimento, double[] notas) { //todo: Inserir alunos egressos de exemplo   
        this.nome = nome;
        this.dataNascimento = dataNascimento;

        validarNotasParams(notas);
        this.notas = notas;
    }

    public Aluno(String prefixoMatricula, String nome, DateType dataNascimento) {  //todo: Matricular novo aluno
       
        this.matricula = prefixoMatricula + contadorMatricula;
        contadorMatricula++;

        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public Aluno(String matricula, String nome) { //todo: Buscar aluno a ser cancelado/tornado egresso
        this.matricula = matricula;
        this.nome = nome;
    }

    public Aluno(String nome, double[] notas) {  //todo: Tornar Aluno Egresso e Cancelar Aluno
        this.nome = nome;
        validarNotasParams(notas);
        this.notas = notas;
    }

     private void validarNotasParams(double[] notas) {
        if (notas.length < 5)
            throw new Error("Devem ser passadas 5 notas...");
        for (double nota : notas) {
            if (nota < 0 || nota > 10)
                throw new Error("Nota informada inválida...");
        }
    }

    private int calcularAjusteDia(int diaAtual) {
        if (this.dataNascimento.getDia() - diaAtual <= 0)
            return 0;
        else
            return -1;
    }
    
    private int calcularAjusteIdade(LocalDate dataAtual) {
        if (this.dataNascimento.getMes() - dataAtual.getMonthValue() < 0)
        return 0;
        else if (this.dataNascimento.getMes() - dataAtual.getMonthValue() == 0)
            return calcularAjusteDia(dataAtual.getDayOfMonth());
        else 
            return -1;        
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getDataNascimento() {
        if (this.dataNascimento == null)
            return "Undefined";
        return String.format("%d/%d/%d", this.dataNascimento.getDia(), this.dataNascimento.getMes(),
                this.dataNascimento.getAno());
    }
    
    public double[] getNotas() {
        if (this.notas == null)
            return new double[] {0.0};
        return this.notas;
    }
    
    public int calcularIdade() {
        LocalDate currentDate = LocalDate.now();
        int idade = currentDate.getYear() - this.dataNascimento.getAno();
        
        return idade + calcularAjusteIdade(currentDate);

    }
    
    public double calcularMediaNotas() {
        double soma = 0.0;
        for (double nota : this.notas)
            soma += nota;
        return soma / this.notas.length;
    }

}