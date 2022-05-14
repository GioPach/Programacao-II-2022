package exerc4.utils;

import exerc4.classes.Filme;
import exerc4.classes.Serie;

import java.util.Set;

public class Listagem {

    public static void listarFilmes(Set<Filme> filmes) {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Filmes =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        for (Filme filme : filmes) {
            System.out.format("Nome: %s | Diretor: %s | Gênero: %s\n",
                    filme.getNome(), filme.getDiretor(), filme.getGenero());
            System.out.format("Duração: %.1f horas | Data de lançamento: %s\n",
                    filme.getDuracaoHoras(), filme.getDataLancamento().verData());
            System.out.println("");
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public static void listarSeries(Set<Serie> series) {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Séries =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        for (Serie serie : series) {
            System.out.format("Nome: %s | Diretor: %s | Gênero: %s\n",
                    serie.getNome(), serie.getDiretor(), serie.getGenero());
            System.out.format("Número de episódios: %d | Data de lançamento: %s\n",
                    serie.getNumeroEpisodios(), serie.getDataLancamento().verData());
            System.out.println("");
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

}
