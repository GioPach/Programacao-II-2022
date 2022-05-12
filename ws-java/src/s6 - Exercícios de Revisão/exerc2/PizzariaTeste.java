public class PizzariaTeste {

    public static void main(String[] args) {

        Ingrediente cal = new Ingrediente();
        cal.setNome("Calabresa");
        cal.setQuantidade(100);//gramas
        
        Ingrediente i2 = new Ingrediente();
        i2.setNome("Rucula");
        i2.setQuantidade(20);     
        
        Borda borda = new Borda();
        borda.setNome("Catupiry");
        borda.setValor(2.50);        
        
        Pizza p = new Pizza();
        p.setPesoBase(200);
        p.setNome("La Fuego");
        p.setValorBase(20.50);
        p.setTamanho('G'); //Observe que é char
        p.addIngrediente(cal);
        p.addIngrediente(i2);
        
        
        
        p.setBorda(borda);
        double peso = p.pesoTotal();//Calcular o peso total da pizza com base 
                                    //nos ingredientes (deve retornar + peso padrão 150) deve retornar em KG.                                     
                                     
        System.out.println("Peso da pizza " + peso);     
        System.out.println("Preço da pizza " + p.calculaPreco());//Usar o valor de borda   
        
        
        System.out.println("Total de ingredientes " + p.getTotalDeIngredientes());//retornar 2
        //Opa digititei um ingrediente a mais
        p.remove(cal);
        System.out.println("Total de ingredientes " + p.getTotalDeIngredientes());//retornar 1
    }
    
}
