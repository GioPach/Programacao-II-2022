package exerc4;

public class Main {

    public static void main(String[] args) {
        Administrador adm1 = new Administrador("Godofredo", "Rua Albino", "3213-3213", 1, 5000.0, 0.1, 250.0);
        System.out.println(adm1.calcularSalario());
    }

}