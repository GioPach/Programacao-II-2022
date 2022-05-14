package exerc3.classes;

import utils.Data;

import java.util.Set;
import java.util.HashSet;

public class Concerto {

    final private static String statusPendente = "Pendente";
    final private static String statusConcluido = "Concluído";

    private static Set<Concerto> concertosConcluidos = new HashSet<Concerto>();
    private static Set<Concerto> concertosPendentes = new HashSet<Concerto>();

    final private Carro carro;
    final private Proprietario proprietario;
    final private String descricaoProblema;
    private Data dataSolicitacao;
    private Data dataConclusao;
    private String status;

    /** Construtoras **/

    // Registro de novo concerto (pendente)
    public Concerto(Carro carro, Proprietario proprietario, String descricaoProblema) {
        this.carro = carro;
        this.proprietario = proprietario;
        this.descricaoProblema = descricaoProblema;
        this.dataSolicitacao = Data.obterDataAtual();
        this.dataConclusao = Data.adicionarIntervaloDias(dataSolicitacao, 14);
        this.status = statusPendente;

        carro.addConcertoHistorico(this);
        concertosPendentes.add(this);
    }

    // Registro de concerto no histórico do carro (concluído)
    public Concerto(Carro carro, Proprietario proprietario, String descricaoProblema, Data dataSolicitacao,
            Data dataConclusao) {
        this.carro = carro;
        this.proprietario = proprietario;
        this.descricaoProblema = descricaoProblema;
        this.dataSolicitacao = Data.validarData(dataSolicitacao);
        this.dataConclusao = Data.validarData(dataConclusao);
        this.status = statusConcluido;

        concertosConcluidos.add(this);
    }

    /** Getters e Setters **/

    public Carro getCarro() {
        return this.carro;
    }

    public Proprietario getProprietario() {
        return this.proprietario;
    }

    public String getDescricaoProblema() {
        return this.descricaoProblema;
    }

    public Data getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(Data dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Data getDataConclusao() {
        return this.dataConclusao;
    }

    public void setDataConclusao(Data dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return this.status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    /** Métodos **/

    private void concluirConcerto(Concerto concertoConcluido) {
        concertoConcluido.setDataConclusao(Data.obterDataAtual());
        concertosConcluidos.add(concertoConcluido);
        concertosPendentes.remove(concertoConcluido);
    }

    public Concerto findConcertoPendente(Concerto concertoTarget) {
        for (Concerto concerto : concertosPendentes) {
            if (concerto == concertoTarget)
                return concerto;
        }
        return null;
    }

    public void resolver() {

        if (this.getStatus().equalsIgnoreCase("Concluído")) {
            System.out.println("\nO concerto já foi concluído...");
            return;
        }

        findConcertoPendente(this).setStatus(statusConcluido);
        concluirConcerto(this);
        System.out.println("Concerto realizado com sucesso...");

    }

    public static void listarConcertosConcluidos() {

        if (concertosConcluidos.isEmpty()) {
            System.out.println("Nenhum concerto concluído está registrado...");
            return;
        }

        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Concertos Concluídos =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for (Concerto concerto : concertosPendentes) {
            System.out.println("\nConcerto ------------------------------------------------------------------------");
            System.out.format("Proprietário: %s\t| Carro: %s\t | Placa: %s\n",
                    concerto.getProprietario().getNome(), concerto.getCarro().getModelo(),
                    concerto.getCarro().getPlaca());

            System.out.format("Data de solicitação: %s\t| Data de conclusão prevista: %s",
                    concerto.getDataSolicitacao().verData(), concerto.getDataConclusao().verData());
            System.out.format("\nDescrição do problema: %s", concerto.getDescricaoProblema());
            System.out.println("\n---------------------------------------------------------------------------------");
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

    }

    public static void listarConcertosPendentes() {

        if (concertosPendentes.isEmpty()) {
            System.out.println("Nenhum concerto pendente está registrado...");
            return;
        }

        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Concertos Pendentes =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        for (Concerto concerto : concertosPendentes) {
            System.out.println("\nConcerto ------------------------------------------------------------------------");
            System.out.format("Proprietário: %s\t| Carro: %s\t | Placa: %s\n",
                    concerto.getProprietario().getNome(), concerto.getCarro().getModelo(),
                    concerto.getCarro().getPlaca());

            System.out.format("Data de solicitação: %s\t| Data de conclusão prevista: %s",
                    concerto.getDataSolicitacao().verData(), concerto.getDataConclusao().verData());
            System.out.format("\nDescrição do problema: %s", concerto.getDescricaoProblema());
            System.out.println("\n---------------------------------------------------------------------------------");
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

    }

    public static void listarConcertos() {

        listarConcertosPendentes();
        listarConcertosConcluidos();

    }

}