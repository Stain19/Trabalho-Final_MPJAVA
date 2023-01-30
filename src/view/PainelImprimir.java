package view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Classe PainelImprimir herda JPanel
 * Na v1.0(ATUAL) não possui funcionalidades, apenas preenche a tela principal
 * Classe PanelCliente herda JPanel
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 *
 */
public class PainelImprimir extends JPanel {
    public PainelImprimir(JFrame frame){
        setLayout(null);
        setBounds(0,frame.getHeight()/2,frame.getWidth()/2,frame.getHeight()/2);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY,Color.GRAY));
        setBackground(Color.LIGHT_GRAY);

    }
}
