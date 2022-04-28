package exerc2;

public class ContaCorrente {

    private double saldo;

    public ContaCorrente() {
        this.saldo = 0.0;
    }

    public ContaCorrente(double saldo) {
        if(saldo > 0.0) this.saldo = saldo;
        else {
            System.out.println("Valor inválido...");
            this.saldo = 0.0;
        }
    }

    private void imprimirSaldo() {
        System.out.format("Saldo atual: R$ %.2f\n", this.saldo);
    }

    public void sacar(double valor) {

        if(this.saldo - valor >= 0) {
            this.saldo -= valor;
            imprimirSaldo();
        } 
        else 
            System.out.println("Impossível sacar este valor da conta...");
        

    }

    public void depositar(double valor) {
        
        if(!(valor <= 0)) {
            this.saldo += valor;
            imprimirSaldo();
        }
        else 
            System.out.println("Impossível depositar este valor na conta...");

    }

    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente();
        c1.sacar(3.9);
        c1.depositar(100.50);
        c1.sacar(4.9);
        c1.sacar(95.5);

    }

}