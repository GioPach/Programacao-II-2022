package exerc1.enums;

public enum Turno {

    DIURNO("diurno"),
    NOTURNO("noturno");

    private String descricao;

    Turno(String descricao) {
        this.descricao = descricao;
    }

    public String getTurno() {
        return this.descricao;
    }

}
