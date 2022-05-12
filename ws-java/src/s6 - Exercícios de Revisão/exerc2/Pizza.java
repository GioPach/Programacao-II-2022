
import java.util.Set;
import java.util.HashSet;

public class Pizza {

    private int pesoBase = 150;
    private String nome;
    private double valorBase;
    private char tamanho;
    private Set<Ingrediente> ingredientes = new HashSet<Ingrediente>();
    private Borda borda;

    public void setPesoBase(int pesoBase) {
        this.pesoBase = pesoBase;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public void setBorda(Borda borda) {
        this.borda = borda;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public void remove(Ingrediente ingrediente) {
        this.ingredientes.remove(ingrediente);
    }

    private double converterGramasParaQuilogramas(double pesoGramas) {
        return pesoGramas / 1000;
    }

    public double pesoTotal() {
        double pesoIngredientes = 0.0;
        for(Ingrediente ingrediente : this.ingredientes) {
            pesoIngredientes += ingrediente.getQuantidade();
        }
        return converterGramasParaQuilogramas(pesoIngredientes + this.pesoBase);
    }

    public double calculaPreco() {
        return this.valorBase + this.borda.getValor();
    }

    public int getTotalDeIngredientes() {
        return this.ingredientes.size();
    }

}