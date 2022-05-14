package exerc4.classes;

import exerc4.model.AbstractVideo;
import utils.*;

public class Serie extends AbstractVideo {

    final private int numeroEpisodios;

    public Serie(String _nome, String _diretor, String _genero, Data _dataLancamento, int numeroEpisodios) {
        super(_nome, _diretor, _genero, _dataLancamento);
        this.numeroEpisodios = VerificadorValidade.validarNumeroNatural(numeroEpisodios);
    }

    public int getNumeroEpisodios() {
        return this.numeroEpisodios;
    }

}