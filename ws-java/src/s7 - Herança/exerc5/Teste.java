package exerc5;

import java.util.Scanner;
import exerc1.Administrativo;
import exerc1.Tecnico;
import exerc1.enums.Turno;
import exerc2.animal.Cachorro;
import exerc2.animal.Gato;
import exerc2.pessoa.Miseravel;
import exerc2.pessoa.Pessoa;
import exerc2.pessoa.Pobre;
import exerc2.pessoa.Rica;
import exerc3.CamaroteInferior;
import exerc3.CamaroteSuperior;
import exerc3.Ingresso;
import exerc3.Normal;
import exerc3.VIP;
import exerc4.Imovel;
import exerc4.Novo;
import exerc4.Velho;

public class Teste {

    public static void main(String... args) {

        // ************* */
        // a

        System.out.println("\n=== Exerc (a): \n");

        // Funcionario func1 = new Funcionario("Wallace", "Diretor", "Financeiro",
        // 12500.0);
        // Gerente gerente1 = new Gerente("Roberta", "RH", 7500.0);
        // Assistente assis1 = new Assistente("Wagner", "Assistente Financeiro",
        // "Financeiro", 3213.0, "02321");
        Tecnico tec1 = new Tecnico("Vargas", "TI", 3500, "02322");
        Administrativo adm1 = new Administrativo("Luís", "Operacional", 5600.0, "02323", Turno.DIURNO);

        System.out.println(tec1.getNome() + " " + tec1.getMatricula());
        System.out.println(adm1.getNome() + " " + adm1.getMatricula());
        // func1.exibeDados();
        // gerente1.exibeDados();
        // assis1.exibeDados();
        // tec1.exibeDados();
        // adm1.exibeDados();

        // ************* */
        // b

        System.out.println("\n=== Exerc (b): \n");

        // Animal animal = new Animal("Baleia", "Salsicha");
        Cachorro cachorro = new Cachorro("Tóbi", "Chow chow");
        Gato gato = new Gato("Frajola", "Siamês");

        System.out.println(cachorro.late());
        System.out.println(gato.mia());
        System.out.println(cachorro.caminha());
        System.out.println(gato.caminha());

        // System.out.println(animal.toString());
        // System.out.println(cachorro.toString());
        // System.out.println(gato.toString());

        // ************* */
        // c

        System.out.println("\n=== Exerc (c): \n");

        Pessoa pessoa = new Pessoa("Jorel", 23);
        Miseravel miseravel = new Miseravel("Lucas", 13, true);
        Rica rico = new Rica("Wagner", 35, 2500.00);
        Pobre pobre = new Pobre("Cidcley", 22, 8);

        System.out.println(pessoa.toString());
        System.out.println(miseravel.toString());
        System.out.println(rico.toString());
        System.out.println(pobre.toString());

        // ************* */
        // d

        System.out.println("\n=== Exerc (d): \n");

        final double valorPadrao = 5.0;
        final double acrescimoCamaroteSuperior = 4.0;

        Scanner sc = new Scanner(System.in);
        Ingresso ingresso = new Ingresso(valorPadrao);

        System.out.print("Compra de Ingresso: digite 1 para normal ou 2 para VIP: ");
        int tipoIngresso = sc.nextInt();

        if (tipoIngresso == 1) {
            Normal ingressoNormal = new Normal(valorPadrao);
            System.out.println(ingressoNormal.toString());
        } else if (tipoIngresso == 2) {
            VIP vip = new VIP(ingresso);
            System.out.println("Selecionado: Ingresso VIP");

            System.out.print("Digite 1 para camarote superior ou 2 para inferior: ");
            int tipoCamarote = sc.nextInt();
            if (tipoCamarote == 1) {
                CamaroteSuperior cameraSuperior = new CamaroteSuperior(vip, acrescimoCamaroteSuperior);
                System.out.println(cameraSuperior.toString());
            } else if (tipoCamarote == 2) {
                CamaroteInferior camaroteInferior = new CamaroteInferior(vip, "Fila A4");
                System.out.println(camaroteInferior.toString());
            } else {
                System.out.println("Tipo de camarote inválido...");
                System.out.println(vip.toString());
            }
        } else {
            System.out.println("Tipo de ingresso inválido...");
            ingresso.imprimeValor();
        }

        // ************* */
        // e

        System.out.println("\n=== Exerc (e): \n");

        Imovel imovel = new Imovel("Rua São Pedro, 234", 250000);
        System.out.print("Digite 1 para imóvel novo ou 2 para velho: ");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            System.out.println("Selecionado: Imóvel Novo");
            Novo novo = new Novo(imovel, 30000);
            novo.imprimirPreco();
        } else if (tipo == 2) {
            System.out.println("Selecionado: Imóvel Velho");
            Velho velho = new Velho(imovel, 5000);
            velho.imprimirPreco();
        } else {
            System.out.println("Tipo de imóvel inválido...");
            imovel.imprimirPreco();
        }

        sc.close();

    }

}