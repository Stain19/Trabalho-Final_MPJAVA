package view.ViewLists;

import view.TelaInicio;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Classe PainelLists herda JPanel
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class PainelLists extends JPanel{
    public JTabbedPane tabbedPane;
    public PanelOrcamento panelOrcamento;
    public PanelProdutos panelProdutos;
    public PanelClientes panelClientes;
    public PainelLists(){
        setLayout(new BorderLayout());
        setBounds(0,0,480,270);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.DARK_GRAY,Color.GRAY));
        setBackground(Color.GRAY);
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.LIGHT_GRAY);
        add(tabbedPane);
    }
    public void createAndShowGUI(TelaInicio telaInicio){
        panelOrcamento = new PanelOrcamento(telaInicio.controleOrcamentos.listarOrcamentos());
        panelProdutos = new PanelProdutos(telaInicio.controleProduto.listarProdutos());
        panelClientes = new PanelClientes(telaInicio.controleClientes.listarClientes());

        tabbedPane.addTab("Orçamento(s)",panelOrcamento);
        tabbedPane.addTab("Produtos",panelProdutos);
        tabbedPane.addTab("Clientes",panelClientes);

    }
}
