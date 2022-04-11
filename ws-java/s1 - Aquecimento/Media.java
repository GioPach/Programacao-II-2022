import java.util.Scanner;
/**
 * Leia até 5 notas de um aluno e calcule a média.
 * 
 * @author Giovani Signori
 * @version 1.0
 */
public class Media
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    //private int x;
    
    public static double calcularMedia(double[] notas) {
        double soma = 0;
        for(double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);        
        double[] notas;
        double media;
        int nNotas;
        
        System.out.print("Digite o numero de notas a serem lidas: ");
        nNotas = sc.nextInt();
        notas = new double[nNotas];
        
        for(int i = 0; i < nNotas; i++) {            
              
            System.out.print(String.format("#Nota %d: ", i+1));
            notas[i] = sc.nextDouble();
                    
        }      
        
        media = calcularMedia(notas);
        System.out.println(String.format("Media final: %.1f", media));
        sc.close();
    }
}
