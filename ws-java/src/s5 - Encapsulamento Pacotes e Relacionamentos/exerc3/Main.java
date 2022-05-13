package exerc3;

import exerc3.classes.*;
import utils.Data;

// 3.  Faça um programa para o Mecanico que possua as classes veiculo, proprietário e concertos

public class Main {

    public static void main(String... args) {
        
        Carro ferrari = new Carro(new Proprietario("juninho", "127.000.000-01", "99332-3232"),
            "Ferrari 448", "IDK7J89", "V8");

        ferrari.addConcertoHistorico(new Concerto(ferrari, ferrari.getProprietario(),
            "Pane elétrico", new Data(1, 2, 2015), new Data(19, 2, 2015)));


        Concerto superaquecimento = new Concerto(ferrari, ferrari.getProprietario(), "Superquecimento do motor");
        
        ferrari.imprimirHistorico();
        ferrari.getProblema(superaquecimento).resolver();
        
        ferrari.imprimirHistorico();
        Concerto.listarConcertosPendentes();
    }

}