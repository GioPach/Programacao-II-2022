package exerc2.classes;

import java.util.Set;
import java.util.HashSet;

public class Agenda {

    private Set<Contato> contatos = new HashSet<Contato>();

    private Contato encontrarContato(String nome) {        
        for(Contato contato : this.contatos) {
            if(contato.getNome().equalsIgnoreCase(nome)) return contato;
        }
        System.out.format("O contato de %s não foi encontrado!\n", nome);
        return null;
    }

    public void addContato(Contato contato) {
        this.contatos.add(contato);
    } 

    public void removerContato(String nome) {
        this.contatos.remove(encontrarContato(nome));
    }

    public void imprimirNumero(String nome) {
        System.out.format("\nContato de %s: %s\n", encontrarContato(nome).getNome(), encontrarContato(nome).getTelefone());
    }

    public void listarContatos() {
        System.out.println("=-=-=-=-=-=-=-=- Contatos =-=-=-=-=-=-=-=-=");
        for(Contato contato : this.contatos) 
            System.out.format("Nome: %s\t| Telefone: %s\n", contato.getNome(), contato.getTelefone());

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");        
    }

}