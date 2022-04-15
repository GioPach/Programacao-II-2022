package classes;

import uteis.DateType;
import java.time.LocalDate;

public class Aluno {

    protected String matricula;
    private static int contadorMatricula = 1;
    private static int contadorEgresso = 1;

    protected String nome;
    protected DateType dataNascimento;
    protected double[] notas = new double[5];
    
    public Aluno(String nome, DateType dataNascimento, double[] notas) {
        //todo: Inserir alunos de exemplo

        //* IDENTIFICAR ALUNOS EGRESSANTES POR UM "." (PONTO) NO INÍCIO DA STRING --> Manter Matrículas Diferentes
        // Exemplo: ".Jorel"
        if (nome.indexOf('.') == 0) {
            this.matricula = "40" + contadorEgresso;
            contadorEgresso++;
        } else {
            this.matricula = "2150" + contadorMatricula;
            contadorMatricula++;
        }
        
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
    
    public Aluno(String nome, DateType dataNascimento) {
        //todo: Matricular novo aluno
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public Aluno(String nome, String matricula, double[] notas) {
        //todo: Tornar Aluno Egresso
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }
    
    public Aluno(String nome, double[] notas) {
        //todo: Cancelar Aluno
        this.nome = nome;
        this.notas = notas;
    }

    protected Aluno(String undefined) {
        //todo: Retornar Aluno Vazio (Buscas)
        this.nome = undefined;
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