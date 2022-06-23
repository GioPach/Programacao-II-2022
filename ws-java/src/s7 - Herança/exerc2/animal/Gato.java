package exerc2.animal;

public class Gato extends Animal {

    public Gato() {

    }

    public Gato(String nome, String raca){
        super(nome, raca);
    }

    public String mia() {
        return "Miando...";
    }

    @Override
    public String toString() {
        return "Gato: nome='" + getNome() + "'" +
        ", raca='" + getRaca() + "', ";
    }

}