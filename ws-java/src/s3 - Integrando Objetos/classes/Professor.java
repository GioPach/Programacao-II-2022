package classes;

import java.util.SortedSet;
import java.util.TreeSet;

public class Professor {

    protected String nome;
    protected String contrato;
    
    protected SortedSet<String> disciplinas = new TreeSet<String>();

    public Professor(String nome, String contrato, String[] disciplinas) {
        this.nome = nome;
        this.contrato = contrato;

        for (String disciplina : disciplinas)
            this.disciplinas.add(disciplina);
    }

    public String getNome() {
        return this.nome;
    }

    public SortedSet<String> getDisciplinas() {
        return this.disciplinas;
    }
    
    public void adicionarDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplina(String disciplina) {
        if (!this.disciplinas.contains(disciplina))
            return;

        this.disciplinas.remove(disciplina);
    }
    
}