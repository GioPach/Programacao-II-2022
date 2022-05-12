package utils;

import java.util.List;
import java.util.Arrays;

public class VerificadorValidade {

    /** Strings **/

    /**
     * Verifica se o nome possui mais de 3 caracteres.
     * @param nome
     * @return true caso o tamanho seja válido, false caso contrário.
     */
    public static boolean verificarTamanhoValidoString(String string) {
        
        if(string.length() < 3) return false;

        return true;

    }

    /**
     * Verifica se o nome possui mais de 3 caracteres.
     * @param nome
     * @return a própria string caso verdadeiro, gera exceção caso contrário.
     */
    public static String validarTamanhoString(String string) {

        if(!verificarTamanhoValidoString(string)) throw new Error("O nome deve possuir mais de 2 caracteres");
        else return string;

    }

    /**
     * Verifica se o nome possui números.
     * @param nome
     * @return true caso possuir, false caso contrário.
     */
    public static boolean verificarNumeroNaString(String string) {

        List<Character> digitos = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        char[] caracteres = string.toCharArray();
        for (char caractere : caracteres) {
            if (digitos.contains(caractere))
                return true;
        }

        return false;

    }

    /**
     * Valida o nome através dos métodos verificarTamanhoValidoString e verificarNumeroNaString
     * @param nome
     * @return nome caso passe pelos critérios ou gera exceção caso contrário.
     */
    public static String validarNome(String nome) {

        if(!verificarTamanhoValidoString(nome)) throw new Error("O nome deve possuir mais de 2 caracteres");
        if(verificarNumeroNaString(nome)) throw new Error("O nome não pode ter dígitos numéricos...");

        return nome;

    }
   
    /** Números **/

    /**
     * Valida a idade passada conforme o critério do sistema (maior que 9 anos e menor que 122).
     * @param nome
     * @return a própria idade caso passe pelo critério ou gera exceção caso contrário.
     */
    public static int validarIdade(int idade) {

        if (idade < 10 || idade > 122)
            throw new Error("Idade mínima para cadastro: 10 anos | Idade máxima para cadastro: 122");
        return idade;

    }

     /**
     * Função geral para validar um número natural.
     * @param nome
     * @return o próprio número ou gera exceção.
     */
    public static int validarNumeroNatural(int numero) {

        if(numero < 0) throw new Error("O número deve ser maior que 0");
        else return numero;

    }

}