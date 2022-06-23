package exerc2.pessoa;

public class Pobre extends Pessoa {

    private int filhos;

    public Pobre() {

    }

    public Pobre(String nome, int idade, int filhos) {
        super(nome, idade);
        this.filhos = filhos;
    }

    public void trabalha() {
        System.out.println("Trabalhando...");
    }

    public int getFilhos() {
        return this.filhos;
    }

    public void setFilhos(int filhos) {
        this.filhos = filhos;
    }

    @Override
    public String toString() {
        return super.toString() + "filhos='" + getFilhos() + "'" + ", ";
    }


}