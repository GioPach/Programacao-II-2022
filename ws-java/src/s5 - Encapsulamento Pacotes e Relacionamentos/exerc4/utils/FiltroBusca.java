package exerc4.utils;

public enum FiltroBusca {

    GENERO("genero"),
    DIRETOR("diretor"),
    DURACAO_HORAS("duracaoHoras"),
    NUMERO_EPISODIOS("numeroEpisodios");

    private String descricao;

    private FiltroBusca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
