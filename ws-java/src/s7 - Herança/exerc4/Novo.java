package exerc4;

public class Novo extends Imovel {

    private double precoAdicional;

    public Novo() {
    }

    public Novo(Imovel imovel, double precoAdicional) {
        this.setEndereco(imovel.getEndereco());
        this.setPreco(imovel.getPreco() + precoAdicional);
        this.precoAdicional = precoAdicional;
    }

    public Novo(String endereco, double preco, double precoAdicional) {
        this.setEndereco(endereco);
        this.setPreco(preco + precoAdicional);
        this.precoAdicional = precoAdicional;
    }

    public double getPrecoAdicional() {
        return this.precoAdicional;
    }

    public void setPrecoAdicional(double precoAdicional) {
        this.precoAdicional = precoAdicional;
    }

}