package exerc7;

import exerc3.Empregado;
import exerc4.Administrador;
import exerc5.Operario;
import exerc6.Vendedor;

/**
 * Escreva um programa de teste adequado para
 * esta classe. Crie um objeto de
 * cada classe e utilize o método ao menos uma
 * vez.
 */

import java.text.NumberFormat;

public class Main {

    public static void printValor(double valor) {
        System.out.println(NumberFormat.getCurrencyInstance().format(valor));
    }

    public static void main(String[] args) {
        Empregado e1 = new Empregado("Adolfo", "Rua Albino", "4002-8922", 0, 4500.0, 0.2);
        Administrador adm1 = new Administrador("Creep", "Rua Levandovski", "3213-3213", 1, 5000.0, 0.3, 560.0);
        Operario op1 = new Operario("Jessica", "Rua Creep", "3213-3213", 2, 4700.0, 0.15, 450.0, 0.25);
        Vendedor v1 = new Vendedor("Cidcley", "Rua Álvares", "3213-3215", 3, 6700.00, 0.1, 670.5, 0.3);

        printValor(e1.calcularSalario()); // 4500 - 4500 * 0.2 = 4500 - 900 = 3600
        printValor(adm1.calcularSalario()); // 5000 - 5000 * 0.3 + 560 = 4060
        printValor(op1.calcularSalario()); // 4700 - 4700 * 0.15 + 450 * 0.25 = 4107.5
        printValor(v1.calcularSalario()); // 6700 - 6700 * 0.1 + 670.5 * 0.3 = 6231.15;
    }

}
