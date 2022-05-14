package exerc4.classes;

import utils.*;
import exerc4.model.AbstractVideo;

public class Filme extends AbstractVideo {

    final private double duracaoHoras;

    public Filme(String _nome, String _diretor, String _genero, Data _dataPublicacao, double duracaoHoras) {
        super(_nome, _diretor, _genero, _dataPublicacao);
        this.duracaoHoras = validarDuracaoHoras(duracaoHoras);
    }

    public double getDuracaoHoras() {
        return this.duracaoHoras;
    }

    private double validarDuracaoHoras(double duracaoHoras) {
        if (duracaoHoras < 1 || duracaoHoras > 6)
            throw new Error("Duração de horas inválida...");

        return duracaoHoras;
    }

}
