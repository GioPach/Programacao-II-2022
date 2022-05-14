package exerc4.classes;

import java.util.List;
import java.util.Set;
import exerc4.utils.Listagem;

import java.util.HashSet;

public class Catalogo {

    final private String nome;
    private Set<Filme> filmes = new HashSet<Filme>();
    private Set<Serie> series = new HashSet<Serie>();
    private Lancamentos lancamentos;

    /** Construtoras **/

    // Novo Catálogo
    public Catalogo(String nome, List<Filme> filmes, List<Serie> series, Lancamentos lancamentos) {
        this.nome = nome;
        for (Filme filme : filmes)
            this.filmes.add(filme);
        for (Serie serie : series)
            this.series.add(serie);
        this.lancamentos = lancamentos;
    }

    // Busca em catálogo por filtro
    public Catalogo(String nome, Set<Filme> filmes, Set<Serie> series) {
        this.nome = nome;
        this.filmes = filmes;
        this.series = series;
    }

    /** Getters **/

    public String getNome() {
        return this.nome;
    }

    public Set<Filme> getFilmes() {
        return this.filmes;
    }

    public Set<Serie> getSeries() {
        return this.series;
    }

    public Lancamentos getLancamentos() {
        return this.lancamentos;
    }

    /** Métodos **/

    // * Filtragem

    public Catalogo filtrarPorGenero(String genero) {
        Set<Filme> filmesPorGenero = new HashSet<Filme>();
        Set<Serie> seriesPorGenero = new HashSet<Serie>();

        for (Filme filme : this.filmes) {
            if (filme.getGenero().equalsIgnoreCase(genero))
                filmesPorGenero.add(filme);
        }

        for (Filme filme : this.lancamentos.getFilmes()) {
            if (filme.getGenero().equalsIgnoreCase(genero))
                filmesPorGenero.add(filme);
        }

        for (Serie serie : this.series) {
            if (serie.getGenero().equalsIgnoreCase(genero)) {
                seriesPorGenero.add(serie);
            }
        }

        for (Serie serie : this.lancamentos.getSeries()) {
            if (serie.getGenero().equalsIgnoreCase(genero)) {
                seriesPorGenero.add(serie);
            }
        }

        return new Catalogo("Busca por Gênero", filmesPorGenero, seriesPorGenero);

    }

    public Catalogo filtrarPorDiretor(String diretor) {
        Set<Filme> filmesPorDiretor = new HashSet<Filme>();
        Set<Serie> seriesPorDiretor = new HashSet<Serie>();

        for (Filme filme : this.filmes) {
            if (filme.getDiretor().equalsIgnoreCase(diretor))
                filmesPorDiretor.add(filme);
        }

        for (Filme filme : this.lancamentos.getFilmes()) {
            if (filme.getDiretor().equalsIgnoreCase(diretor))
                filmesPorDiretor.add(filme);
        }

        for (Serie serie : this.series) {
            if (serie.getDiretor().equalsIgnoreCase(diretor)) {
                seriesPorDiretor.add(serie);
            }
        }

        for (Serie serie : this.lancamentos.getSeries()) {
            if (serie.getDiretor().equalsIgnoreCase(diretor)) {
                seriesPorDiretor.add(serie);
            }
        }

        return new Catalogo("Busca por Diretor", filmesPorDiretor, seriesPorDiretor);

    }

    public Catalogo filtrarFilmesPorDuracaoMax(double duracaoMaxima) {
        Set<Filme> filmesPorDuracao = new HashSet<Filme>();

        for (Filme filme : this.filmes) {
            if (filme.getDuracaoHoras() <= duracaoMaxima)
                filmesPorDuracao.add(filme);
        }

        for (Filme filme : this.lancamentos.getFilmes()) {
            if (filme.getDuracaoHoras() <= duracaoMaxima)
                filmesPorDuracao.add(filme);
        }

        return new Catalogo("Busca por Diretor", filmesPorDuracao, null);

    }

    public Catalogo filtrarSeriesPorNumeroDeEpisodiosMax(int numeroEpisodios) {
        Set<Serie> seriesPorEpisodios = new HashSet<Serie>();

        for (Serie serie : this.series) {
            if (serie.getNumeroEpisodios() <= numeroEpisodios)
                seriesPorEpisodios.add(serie);
        }

        for (Serie serie : this.lancamentos.getSeries()) {
            if (serie.getNumeroEpisodios() <= numeroEpisodios)
                seriesPorEpisodios.add(serie);
        }

        return new Catalogo("Busca por Diretor", null, seriesPorEpisodios);
    }

    public Filme encontrarFilme(String filmeTarget) {
        for (Filme filme : this.filmes) {
            if (filme.getNome().equalsIgnoreCase(filmeTarget))
                return filme;
        }

        for (Filme filme : this.lancamentos.getFilmes()) {
            if (filme.getNome().equalsIgnoreCase(filmeTarget))
                return filme;
        }

        System.out.format("\nO filme %s não está disponível no catálogo.\n", filmeTarget);
        return null;
    }

    public Serie encontrarSerie(String serieTarget) {
        for (Serie serie : this.series) {
            if (serie.getNome().equalsIgnoreCase(serieTarget))
                return serie;
        }

        for (Serie serie : this.lancamentos.getSeries()) {
            if (serie.getNome().equalsIgnoreCase(serieTarget))
                return serie;
        }

        System.out.format("\nA série %s não está disponível no catálogo.\n", serieTarget);
        return null;
    }

    // * Adicioanar e Remover itens

    public void addFilme(Filme filme) {
        if (filme.getIsLancamento()) {
            this.lancamentos.addFilme(filme);
            System.out.format("\nO filme %s foi adicionado à lista de lançamentos.\n", filme.getNome());
            return;
        }

        this.filmes.add(filme);
    }

    public void addSerie(Serie serie) {
        if (serie.getIsLancamento()) {
            this.lancamentos.addSerie(serie);
            System.out.format("\nA série %s foi adicionada à lista de lançamentos.\n", serie.getNome());
            return;
        }

        this.series.add(serie);
    }

    public void removerFilme(Filme filme) {
        if (filme.getIsLancamento()) {
            this.lancamentos.removerFilme(filme);
        } else {
            this.filmes.remove(filme);
        }
    }

    public void removerSerie(Serie serie) {
        if (serie.getIsLancamento()) {
            this.lancamentos.removerSerie(serie);
        } else {
            this.series.remove(serie);
        }
    }

    // * Listagem

    public void listarFilmes() {
        if (!this.filmes.isEmpty()) {
            Listagem.listarFilmes(this.filmes);
        }
        if (!this.lancamentos.getFilmes().isEmpty()) {
            this.lancamentos.listarFilmes();
        }
    }

    public void listarSeries() {
        if (!this.series.isEmpty()) {
            Listagem.listarSeries(this.series);
        }
        if (!this.lancamentos.getSeries().isEmpty()) {
            this.lancamentos.listarSeries();
        }
    }

    public void listarLancamentos() {
        this.lancamentos.listarTodos();
    }

    public void listarItensCatalogo() {
        listarFilmes();
        listarSeries();
    }

}
