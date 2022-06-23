package exerc3;

public class CamaroteSuperior extends VIP {

    private double acrescimoCamarote;

    public CamaroteSuperior() {
    }

    public CamaroteSuperior(VIP ingressoVip, double acrescimoCamarote) {
        this.setValor(ingressoVip.getValor() + acrescimoCamarote);
        this.acrescimoCamarote = acrescimoCamarote;
    }

    public double getAcrescimoCamarote() {
        return this.acrescimoCamarote;
    }

    public void setAcrescimoCamarote(double AcrescimoCamarote) {
        this.acrescimoCamarote = AcrescimoCamarote;
    }

    @Override
    public String toString() {
        return "Ingresso VIP Camarote Superior:\n" + "- Valor: " + super.getValor() +
                "\n- Acréscimo VIP: " + super.getAcrescimoVip() +
                "\n- Acréscimo Camarote Superior: " + this.getAcrescimoCamarote() + "\n";
    }

}