import java.util.Scanner;
/**
 * Desenvolva um algoritmo em Java que leia um número inteiro e imprima o 
 * seu antecessor e seu sucessor.
 * 
 * @author Giovani Signori
 * @version 1.0
 */
public class AntecessorSucessor
{
  
    public static void imprimirAdjacentes(int numero) {
        System.out.println(String.format("Antecessor: %d", numero - 1));
        System.out.print(String.format("Sucessor: %d", numero + 1));
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numero;
        
        System.out.print("Digite um numero inteiro: ");
        numero = sc.nextInt();
        
        imprimirAdjacentes(numero);
        sc.close();
    }
    
}