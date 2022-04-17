package enums;

public enum PrefixoTurmas {
    
    DS1("DS1", "2250"),
    DS2("DS2", "2150"),
    DS3("DS3", "2050"),
    DS4("DS4", "1950");

    private String nomeTurma;
    private String prefixoMatricula;

    PrefixoTurmas(String nomeTurma, String prefixoMatricula) {
        this.nomeTurma = nomeTurma;
        this.prefixoMatricula = prefixoMatricula;
    }

    public String getNomeTurma() {
        return this.nomeTurma;
    }

    public String getPrefixoMatricula() {
        return this.prefixoMatricula;
    }

}
