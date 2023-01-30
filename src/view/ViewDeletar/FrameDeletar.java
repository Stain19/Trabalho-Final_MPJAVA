package view.ViewDeletar;

import org.jdesktop.swingx.JXList;
import view.TelaInicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe FrameDeletar herda JFrame e implementa a interface ActionListener
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class FrameDeletar extends JFrame implements ActionListener {
    private TelaInicio telaInicio;
    private JButton buttonDeletar;
    private JButton buttonCancel;
    private JXList<String> objectJXList;
    private int op;
    public FrameDeletar(TelaInicio telaInicio){
        this.telaInicio = telaInicio;
        setBounds(720,270,480,540);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setFocusable(true);
        setResizable(false);
        buttonDeletar = new JButton("Deletar");
        buttonCancel = new JButton("Cancelar");
        buttonDeletar.setBounds(220,470,120,30);
        buttonDeletar.addActionListener(this);
        add(buttonDeletar);
        buttonCancel.setBounds(350,470,120,30);
        buttonCancel.addActionListener(this);
        add(buttonCancel);


    }

    public void createAndShowGUI(int op){
        this.op = op;
        switch (op){
            case 1 ->{
                objectJXList = new JXList<>(telaInicio.controleOrcamentos.toStringNomeOrcamentos().toArray(new String[telaInicio.controleOrcamentos.getNumOrcamentos()]));

            }
            case 2-> {
                objectJXList = new JXList<>(telaInicio.controleProduto.toStringNomeProdutos().toArray(new String[telaInicio.controleProduto.getNumProdutos()]));
            }
            case 3 -> {
                objectJXList = new JXList<>(telaInicio.controleClientes.toStringNomeClientes().toArray(new String[telaInicio.controleClientes.getNumClientes()]));
            }
        }
        objectJXList.setBounds(50,20,380,400);
        add(objectJXList);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        if(src.equals(buttonDeletar)){
            try {
                switch (op) {
                    case 1 -> {
                        telaInicio.controleOrcamentos.deletarOrcamento(objectJXList.getSelectedIndex());
                        telaInicio.panelLists.panelOrcamento.textArea.setText(telaInicio.controleOrcamentos.listarOrcamentos());
                        setVisible(false);
                    }
                    case 2 -> {
                        telaInicio.controleProduto.deletarProduto(objectJXList.getSelectedIndex());
                        telaInicio.panelLists.panelProdutos.textArea.setText(telaInicio.controleProduto.listarProdutos());
                        setVisible(false);
                    }
                    case 3 -> {
                        telaInicio.controleClientes.deletarCliente(objectJXList.getSelectedIndex());
                        telaInicio.panelLists.panelClientes.textArea.setText(telaInicio.controleClientes.listarClientes());
                        setVisible(false);
                    }
                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null,
                        "ERROR\n"
                                + "SELECIONE O OBJETO A SER DELETADO", null,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (src.equals(buttonCancel)) {
            setVisible(false);
        }
    }
}
