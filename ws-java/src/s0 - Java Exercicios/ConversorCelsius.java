import java.util.*;

/**
 * 1. Escreva um programa que, com base em uma 
 * temperatura em graus celsius, a converta e exiba em Kelvin (K), 
 * Réaumur (Re), Rankine (Ra) e Fahrenheit (F), seguindo as fórmulas: 
 * F = C * 1.8 + 32; 
 * K = C + 273.15; 
 * Re = C * 0.8; 
 * Ra = C * 1.8 + 32 + 459.67
 * 
 * @author Giovani Signori
 * @version 1.0
 */
public class ConversorCelsius {
    
    double temperaturaCelsius;
    Map<String, Double> conversoes = new HashMap<String, Double>(4);

    public ConversorCelsius(double temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
        conversoes.put("Fahrenheit", converterParaFahrenheit(temperaturaCelsius));
        conversoes.put("Kelvin", converterParaKelvin(temperaturaCelsius));
        conversoes.put("Reaumur", converterParaReaumur(temperaturaCelsius));
        conversoes.put("Rankine", converterParaRankine(temperaturaCelsius));
    }
    
    private double converterParaFahrenheit(double temperaturaCelsius) {
        return temperaturaCelsius * 1.8 + 32;
    };
    
    private double converterParaKelvin(double temperaturaCelsius) {
        return temperaturaCelsius + 273.15;
    };
    
    private double converterParaReaumur(double temperaturaCelsius) {
        return temperaturaCelsius * 0.8;
    };
    
    private double converterParaRankine(double temperaturaCelsius) {
        return temperaturaCelsius * 1.8 + 32 + 459.67;
    };

    public void imprimirConversoes() {
        System.out.format("Valor de entrada: %.2f °C\n", this.temperaturaCelsius);
        System.out.format("Valor em Fahrenheit: %.2f °F\n", this.conversoes.get("Fahrenheit"));
        System.out.format("Valor em Kelvin: %.2f K\n", this.conversoes.get("Kelvin"));
        System.out.format("Valor em Réaumur: %.2f R\n", this.conversoes.get("Reaumur"));
        System.out.format("Valor em Rankine: %.2f Ra", this.conversoes.get("Rankine"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temperatura;

        System.out.print("Digite uma temperatura em graus celsius a ser convertida: ");
        temperatura = sc.nextDouble();

        ConversorCelsius cc = new ConversorCelsius(temperatura); // celsius
        cc.imprimirConversoes();

        sc.close();
    }

}