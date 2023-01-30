package view.ViewEditar;

import org.jdesktop.swingx.JXList;
import view.TelaInicio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Classe FrameRemoverProdutoAoOrcamento é utilizado para criar um Frame responsável por dispor um JPanel a qual o usuário selecionará o produto a ser removido do Orcamento
 * @see PanelEditar
 * @see model.Produto
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class FrameRemoverProdutoAoOrcamento extends JFrame{
    private JXList<String> produtosJXList;
    private JButton buttonOkRemoverProdutoAoOrcamento;
    public FrameRemoverProdutoAoOrcamento(TelaInicio telaInicio ){
        setTitle("Remover Produtos do orcamento");
        setBounds(840,405,240,300);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setResizable(false);
        buttonOkRemoverProdutoAoOrcamento = new JButton("Ok");
        buttonOkRemoverProdutoAoOrcamento.setBounds(170,230,60,30);
        buttonOkRemoverProdutoAoOrcamento.addActionListener(e ->{
            telaInicio.panelEditar.frameEditar.setSelecionadosRemover(Arrays.stream(produtosJXList.getSelectedIndices()).boxed().collect(Collectors.toCollection(ArrayList::new)));
            setVisible(false);});
        produtosJXList = new JXList<>(telaInicio.controleProduto.toStringNomeProdutos().toArray(new String[telaInicio.controleProduto.getNumProdutos()]));
        produtosJXList.setBounds(20,20,200,200);
        produtosJXList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        produtosJXList.setLayoutOrientation(JXList.VERTICAL);
        produtosJXList.getSearchable();
        add(buttonOkRemoverProdutoAoOrcamento);
        add(produtosJXList);
    }

    /**
     * Método utilizado para renderizar a tela.
     */
    public void createAndShowGUI(){
        setVisible(true);
    }
}
