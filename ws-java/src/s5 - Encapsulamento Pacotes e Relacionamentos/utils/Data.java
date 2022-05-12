package utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    /** Construtoras **/

    public Data(int dia, int mes, int ano) {

        if(verificarDataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida...");
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        } 

    }

    public Data(Data data) {

        this.dia = data.getDia();
        this.mes = data.getMes();
        this.ano = data.getAno();

    }

    /** Getters **/

    public Data getData() {
        return this;
    }

    public int getDia() { 
        return this.dia; 
    }

    public int getMes() { 
        return this.mes; 
    }

    public int getAno() {
        return this.ano;
    }
    
    /** Setters **/    

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    /** Métodos **/

    /**
     * Verifica se o dia, mês e ano da data passada correspondem aos critérios 
     * de uma data válida.
     * @param dia
     * @param mes
     * @param ano
     * @return true caso a data seja válida, false caso contrário
     */
    private static boolean verificarDataValida(int dia, int mes, int ano) {

        if (!(verificarDiaValido(dia, mes)))
            return false;

        if (!(verificarMesValido(dia, mes)))
            return false;

        if (ano <= 0 || ano > 2500)
            return false;

        else
            return true;

    }
    
    /**
     * Verifica se o dia, mês e ano da data passada correspondem aos critérios 
     * de uma data válida.
     * @param data
     * @return a própria data se for válida ou gera uma exceção caso contrário.
     */
    public static Data validarData(Data data) {


        if (!(verificarDiaValido(data.getDia(), data.getMes()))) {
            throw new Error("Dia da data passada inválido...");
        }
        
        if (!(verificarMesValido(data.getDia(), data.getMes()))) {
            throw new Error("Mês da data passado inválido...");
        } 
        
        if (data.getAno() <= 0 || data.getAno() > 2500) {
            throw new Error("Ano da data passado deve ser maior que 0 e menor que 2500...");
        } 
        
        return data;
        
    }
    
    /**
     * Verifica se o mês é maior que 0 e menor que 13 para corresponder aos meses válidos.
     * Verifica se o mês passado possui 31 dias, caso o dia seja 31.
     * @param dia
     * @param mes
     * @return true caso o mês seja válido, false caso contrário
     */
    private static boolean verificarMesValido(int dia, int mes) {

        int[] meses31 = { 1, 3, 5, 7, 8, 10, 12 };

        if (mes <= 0 || mes > 12) {
            return false;
        }
        if (dia == 31) {
            for (int mes31 : meses31) {
                if (mes == mes31) {
                    return true;
                }
            }
            return false;
        }
        else {
            return true;
        }

    }

    /**
     * Verifica se o dia é maior que 0 e menor que 31.
     * Verifica se o mês é fevereiro e se o dia passado é maior que 28 (número máximo).
     * @param dia
     * @param mes
     * @return true caso o dia seja válido, false caso contrário
     */
    private static boolean verificarDiaValido(int dia, int mes) {

        if (dia <= 0 || dia > 31) {
            return false;
        }
        if (mes == 2) {
            if (dia <= 28) {
                return true;
            }
            return false;
        }
        else {
            return true;        
        }
    }

    /**
     * Obtém a data atual através da lib LocalDate.
     * @return objeto Data interno correspondente
     */
    public static Data obterDataAtual() {           
        LocalDate dataHoje = LocalDate.now();
        return new Data(dataHoje.getDayOfMonth(), dataHoje.getMonthValue(), dataHoje.getYear());
    }

    /**
     * Calcula a data final após determinado número de dias através 
     * das libs Date e Calendar.
     * @param data
     * @param nDias
     * @return data final
     */
    public static Data calcularIntervaloDias(Data data, int nDias) {
        final int corretor = 1;

        Date dataFinal = new Date(data.getAno(), data.getMes() - corretor, data.getDia());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataFinal);
        cal.add(Calendar.DATE, nDias);
        dataFinal = cal.getTime();

        return new Data(dataFinal.getDate(), dataFinal.getMonth() + corretor, dataFinal.getYear());
    }

    public void verData() {
        System.out.format("%02d/%02d/%04d\n", this.dia, this.mes, this.ano);
    }

}