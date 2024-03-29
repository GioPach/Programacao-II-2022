package uteis.Comparators;

import java.util.Comparator;
import classes.Professor;

public class ProfessorComparator implements Comparator<Professor> {
    
    // Definir critério para ordenar SortedSet
    @Override
    public int compare(Professor prof1, Professor prof2) {
        return prof1.getNome().compareTo(prof2.getNome());
    }

}
