public class Lista {

    private Filme[] filmes;
    private int tamanho;

    private static int ultimoIndexLivre = 0;

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        this.filmes = new Filme[tamanho];
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void add(Filme filme) {
        
        if(ultimoIndexLivre == this.tamanho) throw new Error("Array already fulfilled");
        
        this.filmes[ultimoIndexLivre] = filme;
        ultimoIndexLivre++;
        
    }

    public void imprimirElementos() {
        for(Filme filme : this.filmes) {
            if(filme == null) break;
            System.out.format("Nome: %s | Diretor: %s | Duração: %d\n", filme.getNome(), filme.getDiretor(), filme.getDuracao());
        }
    }

}