package view.ViewDeletar;

import view.TelaInicio;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe PanelDeletar herda JPanel e implementa a interface ActionListener
 * @see JPanel
 * @see ActionListener
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class PanelDeletar extends JPanel implements ActionListener {

    public JButton buttonOrcamento;
    public JButton buttonProdutos;
    public JButton buttonClientes;
    private TelaInicio telaInicio;
    private FrameDeletar frameDeletar;

    public PanelDeletar(TelaInicio telaInicio) {
        this.telaInicio = telaInicio;
        setLayout(null);
        setBounds(500, 290, 440, 120);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.DARK_GRAY,Color.gray),"Deletar"));

        buttonOrcamento = new JButton("Deletar Orçamentos");
        buttonOrcamento.setBounds(120,25,200,20);
        buttonOrcamento.addActionListener(this);

        buttonProdutos = new JButton("Deletar Produtos");
        buttonProdutos.setBounds(120,55,200,20);
        buttonProdutos.addActionListener(this);

        buttonClientes = new JButton("Deletar Clientes");
        buttonClientes.setBounds(120,85,200,20);
        buttonClientes.addActionListener(this);



        add(buttonOrcamento);
        add(buttonProdutos);
        add(buttonClientes);

        setBackground(Color.LIGHT_GRAY);
    }
    
    public void actionPerformed(ActionEvent event){
        Object src = event.getSource();
        frameDeletar = new FrameDeletar(telaInicio);
        //
        if (src.equals(buttonOrcamento)){
            frameDeletar.createAndShowGUI(1);
        } else if (src.equals(buttonProdutos)) {
            frameDeletar.createAndShowGUI(2);
        } else if (src.equals(buttonClientes)) {;
            frameDeletar.createAndShowGUI(3);
        }
    }
}
