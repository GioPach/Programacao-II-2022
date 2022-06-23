package exerc3;

public class VIP extends Ingresso {

    private double acrescimoVip = 7.0;

    public VIP() {

    }

    public VIP(VIP ingressoCamarote) {
        super(ingressoCamarote.getValor());
    }

    public VIP(Ingresso ingresso) {
        this.setValor(ingresso.getValor() + acrescimoVip);
    }

    public double getAcrescimoVip() {
        return this.acrescimoVip;
    }

    public void setAcrescimoVip(double acrescimoVip) {
        this.acrescimoVip = acrescimoVip;
    }

    @Override
    public String toString() {
        return "Ingresso VIP:\n" + "- Valor: " + super.getValor() +
                "\n- Acréscimo VIP: " + this.acrescimoVip + "\n";
    }

}