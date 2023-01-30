package view.ViewLists;

import javax.swing.*;
import java.awt.*;
/**
 * Classe PanelProdutos herda JPanel
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class PanelProdutos extends JPanel{
    public JTextArea textArea;
    public PanelProdutos(String produtosLista){
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setBackground(Color.LIGHT_GRAY);

        textArea = new JTextArea(5, 20); // 5 rows and 20 columns
        textArea.setEditable(false);
        textArea.setText(produtosLista);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400,200));
        add(scrollPane);
    }
}
