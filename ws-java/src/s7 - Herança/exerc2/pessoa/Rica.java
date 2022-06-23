package exerc2.pessoa;

public class Rica extends Pessoa {

    private double dinheiro;

    public Rica() {
        
    }

    public Rica (String nome, int idade, double dinheiro) {
        super(nome, idade);
        this.dinheiro = dinheiro;
    }

    public double getDinheiro() {
        return this.dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }


    public void fazCompras() {
        System.out.println("Fazendo compras...");
    }


    @Override
    public String toString() {
        return super.toString() +
            "dinheiro='" + getDinheiro() + "', ";
    }


}