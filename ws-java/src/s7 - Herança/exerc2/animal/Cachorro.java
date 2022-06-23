package exerc2.animal;

public class Cachorro extends Animal {

    public Cachorro() {

    }

    public Cachorro(String nome, String raca){
        super(nome, raca);
    }

    public String late() {
        return "Latindo...";
    }

    @Override
    public String toString() {
        return "Cachorro: nome='" + getNome() + "'" +
        ", raca='" + getRaca() + "', ";
    }

}