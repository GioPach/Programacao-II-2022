package exerc4.classes;

import utils.Data;
import exerc4.utils.Listagem;

import java.util.Set;
import java.util.HashSet;

public class Lancamentos {

    private Set<Filme> lancamentosFilmes = new HashSet<Filme>();
    private Set<Serie> lancamentosSeries = new HashSet<Serie>();

    public Lancamentos(Filme[] filmes, Serie[] series) {
        for (Filme filme : filmes) {
            this.lancamentosFilmes.add(filme);
        }
        for (Serie serie : series) {
            this.lancamentosSeries.add(serie);
        }

    }

    public Set<Filme> getFilmes() {
        return this.lancamentosFilmes;
    }

    public Set<Serie> getSeries() {
        return this.lancamentosSeries;
    }

    public static boolean isLancamento(Data dataLancamento) {
        if (Data.calcularIntervaloEntreDatas(Data.obterDataAtual(), dataLancamento) < 30)
            return true;
        else
            return false;
    }

    public void addFilme(Filme filme) {
        this.lancamentosFilmes.add(filme);
    }

    public void addSerie(Serie serie) {
        this.lancamentosSeries.add(serie);
    }

    public void removerFilme(Filme filme) {
        this.lancamentosFilmes.remove(filme);
    }

    public void removerSerie(Serie serie) {
        this.lancamentosSeries.remove(serie);
    }

    public void listarFilmes() {

        if (this.lancamentosFilmes.isEmpty()) {
            System.out.println("Nenhum filme registrado nos lançamentos.");
            return;
        }

        Listagem.listarFilmes(this.getFilmes());

    }

    public void listarSeries() {
        if (this.lancamentosSeries.isEmpty()) {
            System.out.println("Nenhuma série registrada nos lançamentos.");
            return;
        }

        Listagem.listarSeries(this.getSeries());

    }

    public void listarTodos() {

        System.out.println("\n=-=-=-=-=-=-=-=-=-= Lançamentos =-=-=-=-=-=-=-=-=-=\n");
        Listagem.listarFilmes(this.getFilmes());
        Listagem.listarSeries(this.getSeries());

    }

}