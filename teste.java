package default-package;
        import javax.swing.*;
        import java.awt.*;

public class Teste implements ActionListener {
    private static JFrame frame;
    private static JButton button;

    public Teste() {
        frame = new JFrame("Exemplo de Evento");
        button = new JButton("CLique aqui");

        frame.setSize(300, 100);
        button.setBounds(80, 10, 120, 30);
        frame.setLayout(null);
        frame.add(button);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Teste t = new Teste();
        button.addActionListener(exemplo)
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("O botao foi clicado");
    }
}
