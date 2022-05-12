public class BigoflixTeste {

    public static void main(String[] args) {

        Lista preferidos = new Lista(10);
    
        Filme f1 = new Filme();
        f1.setNome("O Senhor dos Anéis: O Retorn do Rei");
        f1.setDiretor("Peter Jackson");
        f1.setDuracao(38000);
    
        preferidos.add(f1);

        Filme f2 = new Filme();
        f2.setNome("Ford vs Ferrari");
        f2.setDiretor("Anônimo");
        f2.setDuracao(42000);
    
        preferidos.add(f2);

        preferidos.imprimirElementos();

    }

}