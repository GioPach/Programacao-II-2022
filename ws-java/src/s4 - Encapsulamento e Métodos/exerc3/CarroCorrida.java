package exerc3;

public class CarroCorrida {

    private int numero;
    private String nome;
    private String piloto;
    private String equipe;
    private double velocidadeMaxima;
    private double velocidadeAtual = 0.0;
    private boolean ligado = false;

    public CarroCorrida(final int numero, String nome, String piloto, final String equipe, double velocidadeMaxima) {

        this.nome = nome;
        this.numero = numero;
        this.piloto = piloto;
        this.equipe = equipe;
        this.velocidadeMaxima = verificarVelocidadeValida(velocidadeMaxima);

    }

    private double verificarVelocidadeValida(double velocidade) {
        if (velocidade < 0)
            throw new Error("Velocidade inválida...");
        return velocidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe; 
    }

    public void setVelocidadeMaxima(double velocidade) {
        this.velocidadeMaxima = verificarVelocidadeValida(velocidade);
    }

    public void setVelocidadeAtual(double velocidade) {
        this.velocidadeAtual = verificarVelocidadeValida(velocidade);
    }

    public void setStatusLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public int getNumeroCarro() {
        return this.numero;
    }

     public String getNome() {
        return this.nome;
    }

    public String getPiloto() {
        return this.piloto;
    }

    public String getEquipe() {
        return this.equipe;
    }

    public double getVelocidadeMaxima() {
        return this.velocidadeMaxima;
    }

    public double getVelocidadeAtual() {
        return this.velocidadeAtual;
    }

    public boolean getStatusLigado() {
        return this.ligado;
    }

    private void imprimirVelocidadeAtual() {
        System.out.format("%s | Velocidade Atual: %.2f km/h\n", this.nome, this.velocidadeAtual);
    }

    public void acelerar(double velocidade) {
        if (!(this.ligado)) {
            System.out.println("O carro está desligado...");
            return;
        }
        if (this.velocidadeAtual + verificarVelocidadeValida(velocidade) > velocidadeMaxima)
            this.velocidadeAtual = velocidadeMaxima;
        else
            this.velocidadeAtual += velocidade;

        imprimirVelocidadeAtual();
    }

    public void frear(double percentualFrenagem) {
        if (!(this.ligado)) {
            System.out.println("O carro está desligado...");
            return;
        }
        if (percentualFrenagem <= 0 || percentualFrenagem > 1) 
            throw new Error("Percentual de frenagem inválido...");
        
        this.velocidadeAtual -= this.velocidadeAtual * percentualFrenagem;
        imprimirVelocidadeAtual();

    }
    
    public void parar() {
        this.velocidadeAtual = 0.0;
        System.out.println("Carro parado...");
    }

    public void ligar() {
        if (this.ligado) {
            System.out.println("O carro já está ligado...");
            return;
        }

        this.ligado = true;
        System.out.println("Carro ligado...");
    }

    public void desligar() {
        if (!(this.ligado)) {
            System.out.println("O carro já está desligado...");
            return;
        }

        if (!(this.velocidadeAtual == 0.0)) {
            System.out.println("O carro precisa estar parado para ser desligado...");
            return;
        }

        this.ligado = false;
        System.out.println("Carro desligado...");
    }

    
    public static void main(String[] args) {
        
        CarroCorrida rb18 = new CarroCorrida(1, "RB18", "Max Verstappen", "Red Bull", 319.6);
        rb18.ligar();
        rb18.acelerar(320.0);

        CarroCorrida w12 = new CarroCorrida(44, "W12", "Lewis Hamilton", "Mercedes", 328.8);
        w12.ligar();
        w12.acelerar(325.5);

    }


}