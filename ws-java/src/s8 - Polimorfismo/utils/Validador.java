package utils;

import java.util.regex.Pattern;

public class Validador {

    public static boolean isStringVazia(String string) {
        return string == "";
    }

    public static boolean validarNome(String nome) {
        if (isStringVazia(nome) || Pattern.matches("\\d", nome)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarTelefone(String telefone) {
        if (isStringVazia(telefone) || !Pattern.matches("\\d\\d\\d\\d-\\d\\d\\d\\d", telefone)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarPorcentagem(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarNumeroNatural(double numero) {
        return numero >= 0;
    }

}