package exerc2;

import exerc2.classes.*;

// 2. Faça um programa de agenda telefônica, com as classes Agenda e Contato.

public class Main {

    public static void main(String...args) {

        Agenda agenda = new Agenda();
        agenda.addContato(new Contato("Fabrício", "3443-3393"));
        agenda.addContato(new Contato("Agnácio", "99321-3123"));
        agenda.addContato(new Contato("Luke", "4324-8922"));
        agenda.removerContato("Dagoberto"); //não registrado
        agenda.removerContato("Fabrício");
        
        agenda.listarContatos();
        agenda.addContato(new Contato("Dagoberto", "9999-9999"));
        agenda.imprimirNumero("Dagoberto");
    }

}