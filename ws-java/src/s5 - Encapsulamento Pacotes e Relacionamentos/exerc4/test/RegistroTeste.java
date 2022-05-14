package exerc4.test;

import exerc4.classes.*;
import utils.Data;

import java.util.List;
import java.util.ArrayList;

public class RegistroTeste {

    private static List<Filme> criarFilmes() {

        List<Filme> filmes = new ArrayList<Filme>();
        filmes.add(new Filme("Cosmos", "George Lucas", "Suspense", new Data(1, 2, 1972), 2.5));
        filmes.add(new Filme("Jalapão", "Francisca Torres", "Ficção", new Data(3, 7, 2004), 3.5));
        filmes.add(new Filme("O homem de pedra", "Venerdino Lopes", "Terror", new Data(4, 7, 1975), 2));
        filmes.add(new Filme("Catarátas do Iguatemi", "Lorraine Neta", "Ação", new Data(5, 6, 2003), 1.5));

        return filmes;
    }

    private static List<Serie> criarSeries() {

        List<Serie> series = new ArrayList<Serie>();
        series.add(new Serie("Sherlock", "Sir Arthur C. Doyle XXII", "Suspense", new Data(3, 4, 2010), 56));
        series.add(new Serie("Suits", "Aaron NaoLembro", "Drama", new Data(3, 5, 2010), 66));
        series.add(new Serie("MK 20", "Johnny Cage", "Terror", new Data(9, 7, 2010), 92));
        series.add(new Serie("Stranger Things", "Estranho Oliveira", "Terror", new Data(9, 7, 2016), 103));
        series.add(new Serie("Cobra Kai", "Johnny Lawrence - o verdadeiro karatê kid", "Ação", new Data(10, 10, 2018),
                216));

        return series;
    }

    private static Lancamentos criarLancamentos() {

        Lancamentos lancamentos = new Lancamentos(
                new Filme[] {
                        new Filme("Cabra da peste", "Joraima Kabersvalho", "Comédia", Data.obterDataAtual(), 1.4),
                        new Filme("A volta dos que não foram", "Draco Malfoi", "Terror", Data.obterDataAtual(), 1.7)
                },
                new Serie[] {
                        new Serie("Um tira da caatinga", "Graciliano Silva", "Romance", Data.obterDataAtual(), 42),
                        new Serie("Way down we go", "Kaleo", "Musical", new Data(3, 5, 2022), 30),
                        new Serie("The curse of the fold", "Shawn James", "Musical", new Data(9, 5, 2021), 40)
                });
        return lancamentos;
    }

    public static Catalogo criarCatalogo() {

        List<Filme> filmes = RegistroTeste.criarFilmes();
        List<Serie> series = RegistroTeste.criarSeries();
        Lancamentos lancamentos = RegistroTeste.criarLancamentos();
        Catalogo catalogo = new Catalogo("Catálogo 2022", filmes, series,
                lancamentos);

        return catalogo;
    }

}
