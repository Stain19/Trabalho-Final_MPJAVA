package view.ViewLists;



import javax.swing.*;

import java.awt.*;

/**
 * Classe PanelCliente herda JPanel
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class PanelClientes extends JPanel{
    public JTextArea textArea;
    public JScrollPane scrollPane;
    public PanelClientes(String clientesLista){
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setBackground(Color.LIGHT_GRAY);

        textArea = new JTextArea(5, 20); // 5 rows and 20 columns
        textArea.setText(clientesLista);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400,200));
        add(scrollPane);
        System.out.println(textArea.getText());
    }
}
