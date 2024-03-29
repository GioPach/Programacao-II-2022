package classes;

import enums.PrefixoTurmas;
import uteis.DateType;
import java.time.LocalDate;

public class Aluno {

    protected String matricula;
    private static int contadorMatricula = 10;
    protected String nome;
    protected String nomeTurma;
    protected DateType dataNascimento;
    protected double[] notas = new double[5];
    
    public Aluno(String prefixoMatricula, String nome, DateType dataNascimento, double[] notas) { //todo: Inserir alunos de exemplo
        setNomeTurma(prefixoMatricula);
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
        setNomeTurma(prefixoMatricula);
        this.matricula = prefixoMatricula + contadorMatricula;
        contadorMatricula++;

        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public Aluno(String matricula, String nome) { //todo: Buscar aluno a ser cancelado/tornado egresso
        this.matricula = matricula;
        this.nome = nome;
    }

    protected Aluno(String nome, double[] notas) { //todo: Tornar Aluno Egresso e Cancelar Aluno
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
    
    public String getNome() {
        return this.nome;
    }

    public String getNomeTurma() {
        return this.nomeTurma;
    }

    private void setNomeTurma(String prefixoMatricula) {
        for (PrefixoTurmas prefixoCadastrado : PrefixoTurmas.values()) {
            if (prefixoMatricula.compareTo(prefixoCadastrado.getPrefixoMatricula()) == 0) {
                this.nomeTurma = prefixoCadastrado.getNomeTurma();
                break;
            }
        }
        if (this.nomeTurma == null)
            throw new Error("Prefixo informado inválido...");
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getDataNascimento() {
        return String.format("%d/%d/%d", this.dataNascimento.getDia(), this.dataNascimento.getMes(),
                this.dataNascimento.getAno());
    }
    
    public double[] getNotas() {
        return this.notas;
    }
    
    private int calcularAjusteDia(int diaAtual) {
        if (this.dataNascimento.getDia() - diaAtual <= 0)
            return 0;
        else
            return -1;
    }
        
    private int calcularAjusteIdade(LocalDate dataAtual) {
        if (this.dataNascimento.getMes() - dataAtual.getMonthValue() < 0) return 0;
        else if (this.dataNascimento.getMes() - dataAtual.getMonthValue() == 0)
            return calcularAjusteDia(dataAtual.getDayOfMonth());
        else 
            return -1;        
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