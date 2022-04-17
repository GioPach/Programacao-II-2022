package uteis.Comparators;

import java.util.Comparator;
import classes.Aluno;

public class AlunoComparator implements Comparator<Aluno> {
    
    // Definir critério para ordenar SortedSet
    @Override
    public int compare(Aluno aluno1, Aluno aluno2) {
        return aluno1.getNome().compareTo(aluno2.getNome());
    }

}

