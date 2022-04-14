import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Professor {

    protected String nome;
    protected String contrato;
    protected Set<String> disciplinas = new HashSet<String>();

    public Professor(String nome, String contrato, String[] disciplinas) {
        this.nome = nome;
        this.contrato = contrato;

        for (String disciplina : disciplinas)
            this.disciplinas.add(disciplina);
        ordenarDisciplinas();
    }
    
    private void ordenarDisciplinas() {
        Collections.sort(this.disciplinas);
    }

    public void adicionarDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
        ordenarDisciplinas();        
    }

    public void removerDisciplina(String disciplina) {
        if (!this.disciplinas.contains(disciplina))
            return;

        this.disciplinas.remove(disciplina);
    }
    
}