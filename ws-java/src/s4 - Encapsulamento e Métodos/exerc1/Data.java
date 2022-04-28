package exerc1;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {

        if(isValidDate(dia, mes, ano)) {
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

    public int getDia() { 
        return this.dia; 
    }

    public int getMes() { 
        return this.mes; 
    }

    public int getAno() { 
        return this.ano; 
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    private boolean isValidDate(int dia, int mes, int ano) {

        if(dia <= 0 || dia > 31) return false;
        
        if(!(isValidMonth(dia, mes))) return false;

        else return true;

    }

    private boolean isValidMonth(int dia, int mes) {

        int[] meses31 = {1, 3, 5, 7, 8, 10, 12};

        if(mes <= 0 || mes > 12) return false;
        
        if(mes == 2) {
            if(dia > 28) return false;
        }
        
        if(dia == 31) {
            for(int mes31 : meses31) {
                if(mes == mes31) return true;
            }
            return false;
        }
        
        else return true;

    }
    
    public void verData() {

        String dia = "";
        String mes = "";

        if (this.dia == 0) {
            System.out.println("00/00/0000");
            return;
        }

        if(this.dia < 10) dia += "0" + this.dia;
        else dia += this.dia;

        if(this.mes < 10) mes += "0" + this.mes;
        else mes += this.mes;

        System.out.println(dia + "/" + mes + "/" + this.ano);
        
        // System.out.format("%02d/%02d/%04d\n", this.dia, this.mes, this.ano);
    }

    public static void main(String[] args) {

        Data d1 = new Data(3, 5, 2022);
        d1.verData();

        Data d2 = new Data(12, 12, 1950);
        d2.verData();

        Data d3 = new Data(29, 2, 1990);
        d3.verData();

    }

}