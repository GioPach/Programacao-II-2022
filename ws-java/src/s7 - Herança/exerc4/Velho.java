package exerc4;

public class Velho extends Imovel {

    private double desconto;

    public Velho() {
    }

    public Velho(Imovel imovel, double desconto) {
        this.setEndereco(imovel.getEndereco());
        this.setPreco(imovel.getPreco() - desconto);
        this.desconto = desconto;
    }

    public Velho(String endereco, double preco, double desconto) {
        this.setEndereco(endereco);
        this.setPreco(preco + desconto);
        this.desconto = desconto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

}