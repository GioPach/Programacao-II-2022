import javax.swing.JOptionPane;

public class Teste {

    public static void main(String...args) {

        Aluno a = new Aluno();

        String nome = JOptionPane.showInputDialog("Digite seu nome: ");

        a.setNome(nome);

        JOptionPane.showMessageDialog(null, String.format("Olá %s!", a.getNome()));        
     
    }

}