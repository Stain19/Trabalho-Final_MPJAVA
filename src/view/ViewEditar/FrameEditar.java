package view.ViewEditar;

import model.Cliente;
import model.Orcamento;
import model.Produto;
import model.Telefone;
import view.TelaInicio;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe FrameEditar herda JFrame e implementa ActionListener, tem a função de gerar a tela de edição de acordo com o botão pressionado na TelaInicial
 * @see TelaInicio
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */

public class FrameEditar extends JFrame implements ActionListener{
    private final JButton buttonOk;
    private final JButton buttonCancel;
    private JComboBox<String> comboBoxOBJETO;
    private int op;
    private final TelaInicio telaInicio;
    //Para uso do CADASTRAR_ORCAMENTO
    private final JTextField tituloOrcamento;
    private final JTextArea descricaoOrcamento;
    private final JComboBox<String> clientesJComboBox;
    private ArrayList<Integer> selecionadosAdicionar = new ArrayList<>();
    private ArrayList<Integer> selecionadosRemover = new ArrayList<>();

    private final JScrollPane panelProdutos = new JScrollPane();

    //Para o uso do CADASTRAR_CLIENTES
    private final JTextField nomeCliente;
    private final JTextField emailCliente;
    private final JTextField cpf_cnpjCliente;
    private final JCheckBox isPJCliente;
    private final JCheckBox isPFCliente;
    private boolean isPFPJ;
    private final JTextField ddCliente;
    private final JTextField telCliente;
    private final JTextField enderecoCliente;

    //Para uso do CADASTRO_PRODUTO
    private final JTextField valorProduto;
    private final JTextField nomeProduto;
    private final JTextArea descricaoProduto;
    private final JTextField tipoProduto;
    private final JTextField quantidadeProduto;

    public FrameEditar(TelaInicio telaInicio){
            this.telaInicio = telaInicio;
            setBounds(720,270,480,540);
            setBackground(Color.LIGHT_GRAY);
            setLayout(null);
            setFocusable(true);
            setResizable(false);
            buttonOk = new JButton("Ok");
            buttonCancel = new JButton("Cancelar");
            buttonOk.setBounds(280,470,60,30);
            buttonOk.addActionListener(this);
            add(buttonOk);
            buttonCancel.setBounds(350,470,120,30);
            buttonCancel.addActionListener(this);
            add(buttonCancel);
            tituloOrcamento = new JTextField();
            descricaoOrcamento = new JTextArea();
            clientesJComboBox = new JComboBox<>(telaInicio.controleClientes.toStringNomeClientes().toArray(new String[telaInicio.controleClientes.getNumClientes()]));

            valorProduto = new JTextField();
            nomeProduto = new JTextField();
            descricaoProduto = new JTextArea();
            tipoProduto = new JTextField();
            quantidadeProduto = new JTextField();

            nomeCliente = new JTextField();
            emailCliente = new JTextField();
            cpf_cnpjCliente = new JTextField();
            isPJCliente = new JCheckBox("É PJ?");
            isPFCliente = new JCheckBox("É PF?");
            ddCliente = new JTextField();
            telCliente = new JTextField();
            enderecoCliente = new JTextField();
    }

    /**
     * Método utilizado para definir a variável selecionadosAdicionar
     * @since v1.0
     * @param selecionados
     */
    public void setSelecionadosAdicionar(ArrayList<Integer> selecionados){
        this.selecionadosAdicionar = selecionados;
    }

    /**
     * Método utilizado para definir a variável selecionadosRemover
     * @since v1.0
     * @param selecionados
     */
    public void setSelecionadosRemover(ArrayList<Integer> selecionados){
        this.selecionadosRemover = selecionados;
    }

    /**
     * Método utilizado para criar e gerar o frame na tela do usuário de acordo com o botão precionado na TelaInicio.
     * Gera a edição específica do objeto determina pela variável op.
     * @since v1.0
     * @param op
     */
    public void createAndShowGUI(int op){
        this.op = op;
        setVisible(true);
        switch (op) {
            case 1 ->{
                comboBoxOBJETO = new JComboBox<>(telaInicio.controleOrcamentos.toStringNomeOrcamentos().toArray(new String[telaInicio.controleOrcamentos.getNumOrcamentos()]));
            }
            case 2 ->{
                comboBoxOBJETO = new JComboBox<>(telaInicio.controleProduto.toStringNomeProdutos().toArray(new String[telaInicio.controleProduto.getNumProdutos()]));
            }
            case 3 ->{
                comboBoxOBJETO = new JComboBox<>(telaInicio.controleClientes.toStringNomeClientes().toArray(new String[telaInicio.controleClientes.getNumClientes()]));
            }
        }
        comboBoxOBJETO.setBounds(5,5,460,30);
        comboBoxOBJETO.addActionListener(this);
        add(comboBoxOBJETO);

    }

    /**
     * Método implementado da interface ActionListener, tendo a função de peformar a Ação de acordo com o determinado evento
     * @since v1.0
     * @param event
     */
    public void actionPerformed(ActionEvent event){
        Object src = event.getSource();
        if (src.equals(comboBoxOBJETO)) {
            if (op == 1) {
                int selected = comboBoxOBJETO.getSelectedIndex();
                Orcamento orcamento = telaInicio.controleOrcamentos.retornarOrcamento(selected);
                tituloOrcamento.setText(orcamento.getTituloOrcamento());
                descricaoOrcamento.setText(orcamento.getDescricao());
                //TituloOrcamento
                tituloOrcamento.setBounds(30, 70, 420, 30);
                add(tituloOrcamento);
                JPanel panelTituloOrcamento = new JPanel();
                panelTituloOrcamento.setBounds(20, 50, 440, 60);
                add(panelTituloOrcamento);
                panelTituloOrcamento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Titulo Orçamento"));
                //descricao
                descricaoOrcamento.setBounds(30, 130, 420, 100);
                descricaoOrcamento.setLineWrap(true);
                descricaoOrcamento.setBorder(tituloOrcamento.getBorder());//Mesma borda dos outros painéis
                add(descricaoOrcamento);
                JPanel panelDescricaoOrcamento = new JPanel();
                panelDescricaoOrcamento.setBounds(20, 110, 440, 130);
                add(panelDescricaoOrcamento);
                panelDescricaoOrcamento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Descrição Orcamento"));

                //clientes
                JPanel panelClientes = new JPanel();
                panelClientes.setLayout(null);
                panelClientes.setBounds(20, 250, 440, 59);
                panelClientes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Cliente"));
                panelClientes.add(clientesJComboBox);
                clientesJComboBox.setBounds(10, 17, 420, 25);
                add(panelClientes);

                //produtos
                JButton buttonAdicionarProdutoAoOrcamento = new JButton("Adicionar Produto do orcamento");
                JButton buttonRemoverProdutoDoOrcamento = new JButton("Remover Produto do orcamento");
                buttonAdicionarProdutoAoOrcamento.setBounds(70,30,300,30);
                buttonAdicionarProdutoAoOrcamento.addActionListener(e ->{new JFrameAdicionarProdutoAoOrcamento(telaInicio).createAndShowGUI();});
                buttonRemoverProdutoDoOrcamento.setBounds(70,85,300,30);
                buttonRemoverProdutoDoOrcamento.addActionListener(e ->{new FrameRemoverProdutoAoOrcamento(telaInicio).createAndShowGUI();});
                add(panelProdutos);
                panelProdutos.add(buttonAdicionarProdutoAoOrcamento);
                panelProdutos.add(buttonRemoverProdutoDoOrcamento);
                panelProdutos.setLayout(null);
                panelProdutos.setBounds(20, 309, 440, 130);
                panelProdutos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Produtos"));
            } else if (op == 2) {
                int selected = comboBoxOBJETO.getSelectedIndex();
                Produto produto = telaInicio.controleProduto.retornarProduto(selected);
                valorProduto.setText(String.valueOf(produto.getPreco()));
                nomeProduto.setText(produto.getNome());
                descricaoProduto.setText(produto.getDescricao());
                tipoProduto.setText(produto.getTipo());
                quantidadeProduto.setText(String.valueOf(produto.getQuantidade()));
                //valor Produto
                valorProduto.setBounds(30, 60, 420, 30);
                add(valorProduto);
                JPanel panelvalorProduto = new JPanel();
                panelvalorProduto.setBounds(20, 40, 440, 60);
                add(panelvalorProduto);
                panelvalorProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Valor Produto"));

                //nome Produto
                nomeProduto.setBounds(30, 130, 420, 30);
                add(nomeProduto);
                JPanel panelnomeProduto = new JPanel();
                panelnomeProduto.setBounds(20, 110, 440, 60);
                add(panelnomeProduto);
                panelnomeProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Nome Produto"));

                //descricao Produto
                descricaoProduto.setBounds(30, 210, 420, 100);
                descricaoProduto.setLineWrap(true);
                descricaoProduto.setBorder(nomeProduto.getBorder());
                add(descricaoProduto);
                JPanel paneldescricaoProduto = new JPanel();
                paneldescricaoProduto.setBounds(20, 190, 440, 130);
                add(paneldescricaoProduto);
                paneldescricaoProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Descrição Produto"));

                //tipo Produto
                tipoProduto.setBounds(30, 350, 420, 30);
                add(tipoProduto);
                JPanel paneltipoProduto = new JPanel();
                paneltipoProduto.setBounds(20, 330, 440, 60);
                add(paneltipoProduto);
                paneltipoProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Tipo Produto"));

                //quantidade Produto
                quantidadeProduto.setBounds(30, 420, 420, 30);
                add(quantidadeProduto);
                JPanel panelquantidadeProduto = new JPanel();
                panelquantidadeProduto.setBounds(20, 400, 440, 60);
                add(panelquantidadeProduto);
                panelquantidadeProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Quantidade Produto"));
            } else if (op == 3) {
                int selected = comboBoxOBJETO.getSelectedIndex();
                Cliente cliente = telaInicio.controleClientes.retornarCliente(selected);
                nomeCliente.setText(cliente.getNome());
                emailCliente.setText(cliente.getEmail());
                cpf_cnpjCliente.setText(cliente.getCPFCNPJ());
                isPFCliente.setSelected((cliente.getIsPFPJ()));
                isPJCliente.setSelected((!cliente.getIsPFPJ()));
                ddCliente.setText(String.valueOf(cliente.getNumTel().getDD()));
                telCliente.setText(String.valueOf(cliente.getNumTel().getNumero()));
                enderecoCliente.setText(cliente.getEndereco());
                //Nome Cliente
                nomeCliente.setBounds(30, 60, 420, 30);
                add(nomeCliente);
                JPanel panelNomeCliente = new JPanel();
                panelNomeCliente.setBounds(20, 40, 440, 60);
                add(panelNomeCliente);
                panelNomeCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Nome Cliente"));
                //email
                emailCliente.setBounds(30, 130, 420, 30);
                add(emailCliente);
                JPanel panelEmailCliente = new JPanel();
                panelEmailCliente.setBounds(20, 110, 440, 60);
                add(panelEmailCliente);
                panelEmailCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Email Cliente"));
                //Cpf ou cnpj
                cpf_cnpjCliente.setBounds(30, 200, 420, 30);
                add(cpf_cnpjCliente);
                JPanel panelCPFCNPJCliente = new JPanel();
                panelCPFCNPJCliente.setBounds(20, 180, 440, 60);
                add(panelCPFCNPJCliente);
                panelCPFCNPJCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Cpf/Cnpj Cliente"));

                //É PJ ou PF?
                isPJCliente.setBounds(30, 240, 100, 30);
                isPFCliente.setBounds(130, 240, 100, 30);
                add(isPJCliente);
                add(isPFCliente);
                isPFCliente.addActionListener(e -> {
                    isPJCliente.setSelected(false);
                    isPFPJ = true;
                });
                isPJCliente.addActionListener(e -> {
                    isPFCliente.setSelected(false);
                    isPFPJ = false;
                });
                //DD e Telefone
                ddCliente.setBounds(30, 320, 27, 30);
                telCliente.setBounds(67, 320, 100, 30);
                JPanel panelDdTelCliente = new JPanel();
                panelDdTelCliente.setBounds(20, 300, 440, 60);
                add(ddCliente);
                add(telCliente);
                add(panelDdTelCliente);
                panelDdTelCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "DD + Telefone Cliente"));

                //endereço cliente
                enderecoCliente.setBounds(30, 400, 420, 30);
                add(enderecoCliente);
                JPanel panelEnderecoCliente = new JPanel();
                panelEnderecoCliente.setBounds(20, 380, 440, 60);
                add(panelEnderecoCliente);
                panelEnderecoCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Endereço Cliente"));

            }
        }
        if (src.equals(buttonOk)) {
            switch (op){
                case 1 ->{
                    telaInicio.controleOrcamentos.editarOrcamento(comboBoxOBJETO.getSelectedIndex(),tituloOrcamento.getText(),descricaoOrcamento.getText(),telaInicio.controleClientes.retornarCliente(clientesJComboBox.getSelectedIndex()));
                    if(!selecionadosAdicionar.isEmpty()) {
                        for (int indexselectec : selecionadosAdicionar) {
                            telaInicio.controleOrcamentos.adicionarProduto(telaInicio.controleProduto, indexselectec, comboBoxOBJETO.getSelectedIndex());
                        }
                    }
                    else if (!selecionadosRemover.isEmpty()) {
                        for(int indexselected : selecionadosRemover){
                            telaInicio.controleOrcamentos.removerProduto(telaInicio.controleProduto,indexselected,comboBoxOBJETO.getSelectedIndex());
                        }
                    }

                    telaInicio.panelLists.panelOrcamento.textArea.setText(telaInicio.controleOrcamentos.listarOrcamentos());
                }
                case 2 ->{
                   telaInicio.controleProduto.editarProduto(comboBoxOBJETO.getSelectedIndex(),Double.parseDouble(valorProduto.getText()),nomeProduto.getText(),descricaoProduto.getText(),tipoProduto.getText(),Integer.parseInt(quantidadeProduto.getText()));
                   telaInicio.panelLists.panelProdutos.textArea.setText(telaInicio.controleProduto.listarProdutos());
                }
                case 3 ->{
                    telaInicio.controleClientes.editarClientes(comboBoxOBJETO.getSelectedIndex(),nomeCliente.getText(),emailCliente.getText(),cpf_cnpjCliente.getText(),(isPFCliente.isSelected()),new Telefone(Integer.parseInt(ddCliente.getText()),Integer.parseInt(telCliente.getText())),enderecoCliente.getText());
                    telaInicio.panelLists.panelClientes.textArea.setText(telaInicio.controleClientes.listarClientes());
                }
            }
            setVisible(false);
        }
        if (src.equals(buttonCancel)){setVisible(false);}
    }

}
