package exerc2.animal;

public class Animal {

    private String nome;
    private String raca;

    public Animal () {

    }

    public Animal(String nome) {
        this.nome = nome;
    }

    public Animal(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }


    public String caminha() {
        return "Caminhando...";
    }


    @Override
    public String toString() {
        return "Animal: nome='" + getNome() + "'" +
            ", raca='" + getRaca() + "', ";
    }


}