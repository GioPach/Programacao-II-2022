package uteis.Comparators;

import java.util.Comparator;
import classes.Turma;

public class TurmaComparator implements Comparator<Turma> {
    
    // Definir critério para ordenar SortedSet
    @Override
    public int compare(Turma turma1, Turma turma2) {
        return turma1.getNome().compareTo(turma2.getNome());
    }

}