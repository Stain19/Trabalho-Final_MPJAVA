package view.ViewEditar;

import view.TelaInicio;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe PanelEditar herda da classe JPanel e implementa a interface ActionListener, é disposta como painel na TelaInicial, guarda os JButton editar(Orcamento,produto,cliente)
 * @see JPanel
 * @see ActionListener
 * @see TelaInicio
 * @see JButton
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class PanelEditar extends JPanel implements ActionListener {

    public JButton buttonOrcamento;
    public JButton buttonProdutos;
    public JButton buttonClientes;
    private TelaInicio telaInicio;
    public FrameEditar frameEditar;
    public PanelEditar(TelaInicio telaInicio) {
        this.telaInicio = telaInicio;
        setLayout(null);
        setBounds(500, 160, 440, 120);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.DARK_GRAY,Color.gray),"Editar"));

        buttonOrcamento = new JButton("Editar Orçamentos");
        buttonOrcamento.setBounds(120,25,200,20);
        buttonOrcamento.setAlignmentX(CENTER_ALIGNMENT);
        buttonOrcamento.addActionListener(this);

        buttonProdutos = new JButton("Editar Produtos");
        buttonProdutos.setBounds(120,55,200,20);
        buttonProdutos.setAlignmentX(CENTER_ALIGNMENT);
        buttonProdutos.addActionListener(this);

        buttonClientes = new JButton("Editar Clientes");
        buttonClientes.setBounds(120,85,200,20);
        buttonClientes.addActionListener(this);



        add(buttonOrcamento);
        add(buttonProdutos);
        add(buttonClientes);

        setBackground(Color.LIGHT_GRAY);
    }

    /**
     * Método da interface ActionListener serve para implementar a ação captada pela interface
     * @see ActionListener
     * @see ActionEvent
     * @since v1.0
     * @param e
     */
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        frameEditar = new FrameEditar(telaInicio);
        //
        if (src.equals(buttonOrcamento)){
            frameEditar.createAndShowGUI(1);
        } else if (src.equals(buttonProdutos)) {
            frameEditar.createAndShowGUI(2);
        } else if (src.equals(buttonClientes)) {;
            frameEditar.createAndShowGUI(3);
        }
    }
}
