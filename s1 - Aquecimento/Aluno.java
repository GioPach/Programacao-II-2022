import java.util.Scanner;
/**
 * Leia até 100 nomes de alunos e ordene em ordem alfabética.
 * 
 * @author Giovani Signori
 * @version 1.0
 */
public class Aluno
{
    
    public static String[] ordenarAlunos(String[] alunos) {
    
        
        for(int i = 0; i < alunos.length - 1; i++)
        {
            for(int j = i+1; j < alunos.length; j++)
            {
                if(alunos[i].compareTo(alunos[j]) > 0) {
                    String temp = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = temp;
                }
            }
        }
                
        return alunos;
    
    }
    
    public static void imprimirAlunos(String[] alunos) {
        
        System.out.println("\n\t===== Alunos =====\n");
        for(String aluno : alunos){      
            System.out.println(String.format("\t%s", aluno));            
        }        
    
    }   
         
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int nAlunos;
        String[] alunos;
        
        System.out.print("Digite o numero de alunos a serem lidos (minimo = 2, maximo = 100): ");
        nAlunos = sc.nextInt();
        while(nAlunos < 2 || nAlunos > 100) {
           System.out.println("Impossivel ler esta quantidade de alunos...");
           System.out.print("Digite o numero de alunos a serem lidos (minimo = 2, maximo = 100): ");
           nAlunos = sc.nextInt();
        }
        alunos = new String[nAlunos];
        
        for(int i = 0; i < nAlunos; i++){
            System.out.print("Nome do aluno: ");
            alunos[i] = sc.next();
        }
        
        
        alunos = ordenarAlunos(alunos);
        imprimirAlunos(alunos);
        sc.close();
    }
    
}
