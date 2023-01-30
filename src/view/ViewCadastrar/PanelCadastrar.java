package view.ViewCadastrar;

import view.TelaInicio;
import view.ViewCadastrar.FrameCadastrar;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe PanelCadastrar herda a classe JPanel e implementa a classe ActionListener, servindo para
 * dispor os buttons de cadastro dos OBJECTS Orcamento, Produto e Cliente
 * @see model.Orcamento
 * @see model.Produto
 * @see model.Cliente
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2022
 * @version v1.0
 */
public class PanelCadastrar extends JPanel implements ActionListener {
    public TelaInicio telaInicio;
    public JButton buttonOrcamento;
    public JButton buttonProdutos;
    public JButton buttonClientes;
    public FrameCadastrar frameCadastrar;

    public PanelCadastrar(TelaInicio telaInicio) {
        this.telaInicio = telaInicio;
        setLayout(null);
        setBounds(500, 30, 440, 120);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.DARK_GRAY,Color.gray),"Cadastrar"));

        buttonOrcamento = new JButton("Cadastrar Orçamentos");
        buttonOrcamento.setBounds(120,25,200,20);
        buttonOrcamento.addActionListener(this);

        buttonOrcamento.setAlignmentX(CENTER_ALIGNMENT);
        buttonProdutos = new JButton("Cadastrar Produtos");
        buttonProdutos.setBounds(120,55,200,20);
        buttonProdutos.setAlignmentX(CENTER_ALIGNMENT);
        buttonProdutos.addActionListener(this);

        buttonClientes = new JButton("Cadastrar Clientes");
        buttonClientes.setBounds(120,85,200,20);
        buttonClientes.addActionListener(this);



        add(buttonOrcamento);
        add(buttonProdutos);
        add(buttonClientes);

        setBackground(Color.LIGHT_GRAY);

    }

    /**
     * Performa o evento de acordo com o ActionEvent
     * Cria uma instância da classe FrameCadastrar enviando como parametro a operação
     * e a depender do JButton que retornou o evento.
     * Para buttonOrcamento, envia a operação 1 e abre uma janela para cadastro de orcamento;
     * para buttonProduto, envia a operação 2 e abre uma janela para cadastro de produto;
     * para buttonCliente, envia a operação 3 e abre uma janela para cadastro de um produto;
     * @see FrameCadastrar
     * @see ActionEvent
     * @return void
     * @param e
     * @since v1.0
     */
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        frameCadastrar = new FrameCadastrar(telaInicio);
        //
        if (src.equals(buttonOrcamento)){
            frameCadastrar.createAndShowGUI(1);
        } else if (src.equals(buttonProdutos)) {
            frameCadastrar.createAndShowGUI(2);
        } else if (src.equals(buttonClientes)) {;
            frameCadastrar.createAndShowGUI(3);
        }
    }

}
