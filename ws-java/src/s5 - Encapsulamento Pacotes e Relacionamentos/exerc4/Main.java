package exerc4;

import exerc4.classes.*;
import exerc4.test.RegistroTeste;
import exerc4.utils.FiltroBusca;

// 4. Crie um sistema para controlar filmes em um software como o Netflix. Classes Filme, Serie, MinhaLista e Lançamentos. 
// Escreva de 3 a 4 atributos por classe.
// Utilize ArrayList no exercício 4

public class Main {

    public static void main(String... args) {

        Catalogo catalogo = RegistroTeste.criarCatalogo();

        MinhaLista lista1 = new MinhaLista("Lista 1", FiltroBusca.GENERO, "Terror", catalogo);
        lista1.addFilme(catalogo.encontrarFilme("O homem de pedra"));
        lista1.verItens();

        MinhaLista lista2 = new MinhaLista("Favoritos", FiltroBusca.DURACAO_HORAS, 1.8, catalogo);
        lista2.addSerie(catalogo.encontrarSerie("Cobra kai"));
        lista2.verItens();

        lista1.renomearLista("Melhores de 2022");
        lista1.removerFilme("A volta dos que não foram");
        lista1.addSerie(catalogo.encontrarSerie("Suits"));

        lista1.verItens();

    }

}