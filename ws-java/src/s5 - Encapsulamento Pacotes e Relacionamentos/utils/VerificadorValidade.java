package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Pattern digitos = Pattern.compile("[0-9]");
        Matcher matcher = digitos.matcher(string);

        if (matcher.find())
            return true;
        else
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

         if (numero < 0)
             throw new Error("O número deve ser maior que 0");
         else
             return numero;

    }
    
    // Número de Telefone
    public static String validarTelefone(String telefone) {
        final String msgErro = "Número de telefone inválido";

        if (telefone.length() < 9 || telefone.length() > 10)
            throw new Error(msgErro);
        if (telefone.length() == 10 && telefone.charAt(0) != '9')
            throw new Error(msgErro);

        Pattern regexTelefone = Pattern.compile("9?\\d\\d\\d\\d-\\d\\d\\d\\d");
        Matcher matcher = regexTelefone.matcher(telefone);

        if (matcher.find())
            return telefone;
        else 
            throw new Error(msgErro);

    }

    public static String validarCpf(String cpf) {
        final String msgErro = "CPF inválido...";

        if (cpf.length() != 14)
            throw new Error(msgErro);

        Pattern regexCpf = Pattern.compile("\\d\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d\\d");
        Matcher matcher = regexCpf.matcher(cpf);

        if(matcher.find()) 
            return cpf;
        else 
            throw new Error(msgErro);
    }

}