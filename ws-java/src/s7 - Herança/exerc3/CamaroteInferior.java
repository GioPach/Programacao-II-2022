package exerc3;

public class CamaroteInferior extends VIP {

    private String localizacao;

    public CamaroteInferior() {

    }

    public CamaroteInferior(VIP ingressoVip, String localizacao) {
        super(ingressoVip);
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void imprimirLocalizacao() {
        System.out.println(this.localizacao);
    }

    @Override
    public String toString() {
        return "Ingresso VIP Camarote Inferior:\n" + "- Valor: " + super.getValor() +
                "\n- Acréscimo VIP: " + super.getAcrescimoVip() +
                "\n- Localização: " + this.getLocalizacao() + "\n";
    }

}