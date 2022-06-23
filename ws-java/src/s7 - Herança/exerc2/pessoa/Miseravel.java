package exerc2.pessoa;

public class Miseravel extends Pessoa {

    public boolean vivo;

    public Miseravel() {

    }

    public Miseravel(String nome, int idade, boolean vivo) {
        super(nome, idade);
        this.vivo = vivo;
    }


    public boolean isVivo() {
        return this.vivo;
    }

    public boolean getVivo() {
        return this.vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void mendiga() {
        System.out.println("Mendigando...");
    }

    @Override
    public String toString() {
        return super.toString() + "vivo='" + isVivo() + "'" + ", ";
    }


}