package exerc3;

public class Main {

    public static void main(String...args) {
        Empregado e1 = new Empregado("Adolfo", "Rua Albino", "3213-3213", 0, 5000.0, 0.1);
        System.out.println(e1.calcularSalario());
    }

}