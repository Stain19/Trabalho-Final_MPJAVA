package view.ViewLists;

import javax.swing.*;
import java.awt.*;
/**
 * Classe PanelOrcamento herda JPanel
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class PanelOrcamento extends JPanel{
    public JTextArea textArea;
    public PanelOrcamento(String orcamentosLista){
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setBackground(Color.LIGHT_GRAY);

        textArea = new JTextArea(5, 20);
        textArea.setLayout(null);// 5 rows and 20 columns
        textArea.setText(orcamentosLista);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400,200));
        add(scrollPane);
    }
}
