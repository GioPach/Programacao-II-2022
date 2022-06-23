package exerc4;

public class Imovel {

    private String endereco;
    private double preco;

    public Imovel() {
    }

    public Imovel(String endereco, double preco) {
        this.endereco = endereco;
        this.preco = preco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void imprimirPreco() {
        System.out.format("Preço: R$ %.2f\n", this.getPreco());
    }

}