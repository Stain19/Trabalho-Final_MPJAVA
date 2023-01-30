package view.ViewEditar;

import org.jdesktop.swingx.JXList;
import view.TelaInicio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A classe JFrameAdicionarProdutoAoOrcamento é utilizada para criar um Frame responsável por dispor um JPanel a qual o usuário selecionará os produtos a serem adcionados ao Orcamento
 * @see PanelEditar
 * @see model.Produto
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class JFrameAdicionarProdutoAoOrcamento extends JFrame {
        private JXList<String> produtosJXList;
        private JButton buttonOkAdicionarProdutoAoOrcamento;
        public JFrameAdicionarProdutoAoOrcamento(TelaInicio telaInicio ){
            setTitle("Adicionar Produtos Ao Orcamento");
            setBounds(840,405,240,300);
            setBackground(Color.LIGHT_GRAY);
            setLayout(null);
            setResizable(false);
            buttonOkAdicionarProdutoAoOrcamento = new JButton("Ok");
            buttonOkAdicionarProdutoAoOrcamento.setBounds(170,230,60,30);
            buttonOkAdicionarProdutoAoOrcamento.addActionListener(e ->{
                telaInicio.panelEditar.frameEditar.setSelecionadosAdicionar(Arrays.stream(produtosJXList.getSelectedIndices()).boxed().collect(Collectors.toCollection(ArrayList::new)));
                setVisible(false);});
            produtosJXList = new JXList<>(telaInicio.controleProduto.toStringNomeProdutos().toArray(new String[telaInicio.controleProduto.getNumProdutos()]));
            produtosJXList.setBounds(20,20,200,200);
            produtosJXList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            produtosJXList.setLayoutOrientation(JXList.VERTICAL);
            produtosJXList.getSearchable();
            add(buttonOkAdicionarProdutoAoOrcamento);
            add(produtosJXList);
        }

    /**
     * Método utilizado para renderizar a tela
     */
    public void createAndShowGUI(){
            setVisible(true);
        }
}
