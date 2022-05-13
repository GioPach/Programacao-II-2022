package exerc3.classes;

import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Carro {
    
    final private Proprietario proprietario;
    final private String modelo;
    final private String placa;
    private String motor;
    private Set<Concerto> historicoConcertos = new HashSet<Concerto>();

    //** Construtoras **/

    public Carro(Proprietario proprietario, String modelo, String placa, String motor) {
        this.proprietario = proprietario;
        proprietario.setCarro(this);

        this.modelo = modelo;
        this.placa = validarPlaca(placa);
        this.motor = motor;
    }

    //** Getters e Setters **/

    public Proprietario getProprietario() {
        return this.proprietario;
    }
    
    public String getModelo() {
        return this.modelo;
    }

    public String getPlaca() {
        return this.placa;
    }
    
    public String getMotor() {
        return this.motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Set<Concerto> getHistoricoConcertos() {
        return this.historicoConcertos;
    }

    public void setHistoricoConcertos(Set<Concerto> historicoConcertos) {
        this.historicoConcertos = historicoConcertos;
    }
  
    /** Métodos **/

    private String validarPlaca(String placa) {

        if (placa.length() != 7)
            throw new Error("O número da placa deve ter 7 caracteres...");

        // \p{Lu} matches a uppercase letter that has a lower case variant
        Pattern regexPlaca = Pattern.compile("\\p{Lu}\\p{Lu}\\p{Lu}\\d\\p{Lu}\\d\\d");
        Matcher matcher = regexPlaca.matcher(placa);

        if (matcher.find())
            return placa;
        else
            throw new Error("Número da placa inválido...");

    }

    public Concerto getProblema(Concerto concertoTarget) {
        if (concertoTarget.getStatus().equalsIgnoreCase("Pendente")) {
            for (Concerto concerto : this.historicoConcertos) {
                if (concerto == concertoTarget) {
                        return concerto;
                }
            }
        }

        return null;

    }

    public void addConcertoHistorico(Concerto concerto) {
        this.historicoConcertos.add(concerto);
    }

    public void imprimirHistorico() {
        if (this.historicoConcertos.isEmpty()) {
            System.out.format("Histórico do carro %s, pertencente a %s, não possui registros...",
                this.getModelo(), this.getProprietario().getNome());
            return;
        }

        System.out.format("\n=-=-=-=-=-=-=-=-= Histórico de concertos de (%s | %s) =-=-=-=-=-=-=-=-=\n\n", this.getModelo(), this.getPlaca());
        for (Concerto concerto : this.historicoConcertos) {
            System.out.format("Problema: %s | Status do concerto: %s\n",
                    concerto.getDescricaoProblema(), concerto.getStatus());
            if (concerto.getStatus().equalsIgnoreCase("Concluído")) {
                System.out.format("\t  Data de conclusão: %s\n", concerto.getDataConclusao().verData());
            }
            else {
                System.out.format("\t  Previsão de conclusão: %s\n", concerto.getDataConclusao().verData());
            }
            System.out.println();
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        
    }

}   
