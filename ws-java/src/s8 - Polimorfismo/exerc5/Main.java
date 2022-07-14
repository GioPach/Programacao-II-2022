package exerc5;

public class Main {

    
    public static void main(String[] args) {
        Operario op1 = new Operario("Rodolfo", "Rua Albino", "4314-4314", 3, 5000.0, 0.1, 300.0, 0.1);
        System.out.println(op1.calcularSalario());
    }
}