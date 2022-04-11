import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leia até 100 nomes de alunos e ordene em ordem alfabética.
 * 
 * @author Giovani Signori
 * @version 1.0
 */
public class AlunoSort
{
    
        public static void imprimirAlunos(List<String> alunos) {
        
        System.out.println("\n\t===== Alunos =====\n");
        for(String aluno : alunos){      
            System.out.println(String.format("\t%s", aluno));            
        }        
    
    }   
         
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int nAlunos;
        
        String nome;
        List<String> alunos = new ArrayList<String>();
              
        System.out.print("\nDigite o numero de alunos a serem lidos (minimo = 2, maximo = 100): ");
        nAlunos = sc.nextInt();
        while(nAlunos < 2 || nAlunos > 100) {
           System.out.println("Impossivel ler esta quantidade de alunos...");
           System.out.print("Digite o numero de alunos a serem lidos (minimo = 2, maximo = 100): ");
           nAlunos = sc.nextInt();
        }
        
        
        for(int i = 0; i < nAlunos; i++){
            System.out.print("Nome do aluno: ");
            nome = sc.next();
            alunos.add(nome);
        }
        
        Collections.sort(alunos);
        //alunos = ordenarAlunos(alunos);
        imprimirAlunos(alunos);
        sc.close();
    }
    
}
