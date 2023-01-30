package view;

import controller.ControleClientes;
import controller.ControleOrcamentos;
import controller.ControleProduto;
import view.ViewCadastrar.PanelCadastrar;
import view.ViewDeletar.PanelDeletar;
import view.ViewEditar.PanelEditar;
import view.ViewLists.PainelLists;

import javax.swing.*;
import java.awt.*;

/**
 * Classe da tela de inicio.Nessa classe o JFrame e gerado junto a todos os seus componentes
 * @autor Pedro de Morais
 * @version 1.00
 * @since etapa de criacao da view 24/01/2023
 */

public class TelaInicio extends JFrame{
    public ControleOrcamentos controleOrcamentos = new ControleOrcamentos();
    public ControleProduto controleProduto = new ControleProduto();
    public ControleClientes controleClientes = new ControleClientes();
    public PanelCadastrar panelCadastrar = new PanelCadastrar(this);
    public PanelEditar panelEditar = new PanelEditar(this);
    public PainelLists panelLists;



    public TelaInicio(){
    }

    /**
     * Metodo utilizado para renderizar a TelaInicial
     */
    public void createAndShowGUI() {
        setTitle("Controle de Orçamento");
        //calcula as dimensoes da tela e armazena na variavel screenSize
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        //Define setBounds da JanelaInicial para as dimensoes frameSize
        int frameSizeWidth = screenSize.width / 2;
        int frameSizeHeight = screenSize.height / 2;
        setBounds(480,270, frameSizeWidth, frameSizeHeight);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = this.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);



        panelLists =  new PainelLists();

        PainelImprimir panelImprimir = new PainelImprimir(this);
        PanelDeletar panelDeletar = new PanelDeletar(this);


        setLayout(null);
        c.add(panelCadastrar);
        c.add(panelLists);
        c.add(panelImprimir);
        c.add(panelEditar);
        c.add(panelDeletar);

        panelLists.createAndShowGUI(this);

        setVisible(true);

    }
}
