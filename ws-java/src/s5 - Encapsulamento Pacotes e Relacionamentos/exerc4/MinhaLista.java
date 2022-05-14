package exerc4;

import exerc4.classes.*;
import exerc4.utils.FiltroBusca;
import exerc4.utils.Listagem;

import java.util.Set;
import java.util.HashSet;

public class MinhaLista {

    private String nome;
    private Set<Filme> filmes = new HashSet<Filme>();
    private Set<Serie> series = new HashSet<Serie>();

    // Lista Vazia
    public MinhaLista(String nome) {
        this.nome = nome;
    }

    // Lista por filtragem - Strings
    public MinhaLista(String nome, FiltroBusca filtro, String chave, Catalogo catalogo) {
        this.nome = nome;

        if (FiltroBusca.GENERO.equals(filtro)) {
            final Catalogo buscaPorGenero = catalogo.filtrarPorGenero(chave);
            this.filmes = buscaPorGenero.getFilmes();
            this.series = buscaPorGenero.getSeries();
            imprimirNumeroDeItens();
        } else if (FiltroBusca.DIRETOR.equals(filtro)) {
            final Catalogo buscarPorDiretor = catalogo.filtrarPorDiretor(chave);
            this.filmes = buscarPorDiretor.getFilmes();
            this.series = buscarPorDiretor.getSeries();
            imprimirNumeroDeItens();
        } else {
            System.out.println("Filtro de busca inválido...");
            imprimirNumeroDeItens();
        }

    }

    // Lista por filtragem - Números
    public MinhaLista(String nome, FiltroBusca filtro, double chave, Catalogo catalogo) {
        this.nome = nome;

        if (FiltroBusca.DURACAO_HORAS.equals(filtro)) {
            this.filmes = catalogo.filtrarFilmesPorDuracaoMax(chave).getFilmes();
            imprimirNumeroDeItens();
        } else if (FiltroBusca.NUMERO_EPISODIOS.equals(filtro)) {
            this.series = catalogo.filtrarSeriesPorNumeroDeEpisodiosMax((int) chave).getSeries();
            imprimirNumeroDeItens();
        } else {
            System.out.println("Filtro de busca inválido...");
            imprimirNumeroDeItens();
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void renomearLista(String novoNome) {
        this.nome = novoNome;
    }

    private void imprimirNumeroDeItens() {
        System.out.format("\nLista iniciada contém %d itens\n", this.filmes.size() + this.series.size());
    }

    public void addFilme(Filme filme) {
        this.filmes.add(filme);
    }

    public void addSerie(Serie serie) {
        this.series.add(serie);
    }

    public void removerFilme(String filmeTarget) {
        for (Filme filme : this.filmes) {
            if (filme.getNome().equalsIgnoreCase(filmeTarget)) {
                this.filmes.remove(filme);
                return;
            }
        }
    }

    public void removerSerie(String serieTarget) {
        for (Filme filme : this.filmes) {
            if (filme.getNome().equalsIgnoreCase(serieTarget)) {
                this.filmes.remove(filme);
                return;
            }
        }
    }

    public void verItens() {
        System.out.format("\n.................. Lista: (%s) ..................\n", this.getNome());
        Listagem.listarFilmes(this.filmes);
        Listagem.listarSeries(this.series);
    }

}