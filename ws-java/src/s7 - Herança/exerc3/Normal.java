package exerc3;

public class Normal extends Ingresso {

    public Normal() {

    }

    public Normal(Ingresso ingresso) {
        super(ingresso.getValor());
    }

    public Normal(double valor) {
        super(valor);
    }

    public void imprimirTipo() {
        System.out.println("Ingresso Normal");
    }

    @Override
    public String toString() {
        return "Ingresso Normal:\n" + "- Valor: " + super.getValor() + "\n";
    }

}