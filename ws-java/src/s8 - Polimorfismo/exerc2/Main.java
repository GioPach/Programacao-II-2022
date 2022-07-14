package exerc2;

import exerc1.Pessoa;

public class Main {

    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa("Adolfo", "Rua Evaristo", "3213-3213");
        System.out.println(p1);

        Fornecedor f1 = new Fornecedor("Rodrigo", "Rua Albino", "3213-3213", 390.50, 190.50);
        System.out.println(f1);

        System.out.println("Saldo: " + f1.obterSaldo());

    }

}