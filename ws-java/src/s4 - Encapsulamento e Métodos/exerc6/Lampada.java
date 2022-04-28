package exerc6;

public class Lampada {

    private boolean ligada;

    public Lampada(boolean ligada) {
        this.ligada = ligada;
    }

    public void interruptor() {
        this.ligada = !this.ligada;
    }

    public void exibirStatus() {
        if (ligada)
            System.out.println("A lâmpada está ligada...");
        else
            System.out.println("A lâmpada está desligada...");
    }
    
    public static void main(String[] args) {
        
        Lampada l1 = new Lampada(true);
        l1.interruptor();
        l1.exibirStatus();

        l1.interruptor();
        l1.exibirStatus();

    }

}