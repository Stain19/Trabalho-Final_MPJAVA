package view.ViewCadastrar;

import view.TelaInicio;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Classe a qual gera um JFrame onde será exibido ao usuário um painel de cadastro das opções
 * orcamento,produto e cliente. Ao preencher todos os campos necessários, a classe cria o Objeto
 * solicitado, adiciona a um ArrayList contido detro do Controle[OBJETO] e atualiza o PanelOBJETO,
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class FrameCadastrar extends JFrame{
        private final JButton buttonOk = new JButton("Ok");
        private final JButton buttonCancel = new JButton("Cancelar");
        private final TelaInicio telaInicio;
        private int op;
        //Para uso do CADASTRAR_ORCAMENTO
        private JTextField tituloOrcamento;
        private JTextField valorOrcamento;
        private JTextArea descricaoOrcamento;
        private JComboBox<String> clientesJComboBox;
        private JComboBox<String> produtosJComboBox;
        
        //Para o uso do CADASTRAR_CLIENTES
        private JTextField nomeCliente;
        private JTextField emailCliente;
        private JTextField cpf_cnpjCliente;
        private JCheckBox isPJCliente;
        private JCheckBox isPFCliente;
        private boolean isPFPJ;
        private JTextField ddCliente;
        private JTextField telCliente;
        private JTextField enderecoCliente;

        //Para uso do CADASTRO_PRODUTO
        private JTextField valorProduto;
        private JTextField nomeProduto;
        private JTextArea descricaoProduto;
        private JTextField tipoProduto;
        private JTextField quantidadeProduto;



    public FrameCadastrar( TelaInicio telaInicio ){
        this.telaInicio = telaInicio;
        //No momento da instanciação da classe, é criado o ActionListener dos JButtons ok e cacelar
        /*Caso o registro de um OBJETO não de certo, o programa mandara uma mensagem de erro
         * e pedirá ao usuário que redigite os campos necessários, limpando logo em seguida os
         * JTextField's.*/
        buttonOk.addActionListener(e -> {this.setVisible(false);
            switch (op) {
                case 1 -> {
                    try {
                        telaInicio.controleOrcamentos.cadastrarOrcamento(telaInicio.controleClientes, telaInicio.controleProduto, telaInicio.controleClientes.getClientIndex(clientesJComboBox.getName()), tituloOrcamento.getText(), Integer.parseInt(valorOrcamento.getText()), descricaoOrcamento.getText());
                        telaInicio.controleOrcamentos.adicionarProduto(telaInicio.controleProduto,produtosJComboBox.getSelectedIndex(),telaInicio.controleOrcamentos.getNumOrcamentos()-1);
                        telaInicio.panelLists.panelOrcamento.textArea.setText(telaInicio.controleOrcamentos.listarOrcamentos());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "ERROR\n"
                                        + "PREENCHA TODOS OS CAMPOS E TENTE NOVAMENTE", null,
                                JOptionPane.INFORMATION_MESSAGE);

                        createAndShowGUI(1);
                        tituloOrcamento.setText(null);
                        valorOrcamento.setText(null);
                        descricaoOrcamento.setText(null);
                    }
                }
                case 2 -> {
                    try {
                        telaInicio.controleProduto.registrarProduto(Double.parseDouble(valorProduto.getText()), nomeProduto.getText(), descricaoProduto.getText(), tipoProduto.getText(), Integer.parseInt(quantidadeProduto.getText()));
                        telaInicio.panelLists.panelProdutos.textArea.setText(telaInicio.controleProduto.listarProdutos());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "ERROR\n"
                                        + "PREENCHA TODOS OS CAMPOS E TENTE NOVAMENTE", null,
                                JOptionPane.INFORMATION_MESSAGE);
                        valorProduto.setText(null);
                        nomeProduto.setText(null);
                        descricaoProduto.setText(null);
                        tipoProduto.setText(null);
                        quantidadeProduto.setText(null);
                        createAndShowGUI(2);
                    }
                }
                case 3 -> {
                    try {
                        telaInicio.controleClientes.registrarCliente(nomeCliente.getText(), emailCliente.getText(), cpf_cnpjCliente.getText(), isPFPJ, Integer.parseInt(ddCliente.getText()), Integer.parseInt(telCliente.getText()), enderecoCliente.getText());
                        telaInicio.panelLists.panelClientes.textArea.setText(telaInicio.controleClientes.listarClientes());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "ERROR\n"
                                        + "PREENCHA TODOS OS CAMPOS E TENTE NOVAMENTE", null,
                                JOptionPane.INFORMATION_MESSAGE);
                        //Apaga todas as info contidas dentro dos campos
                        nomeCliente.setText(null);
                        emailCliente.setText(null);
                        cpf_cnpjCliente.setText(null);
                        ddCliente.setText(null);
                        telCliente.setText(null);
                        enderecoCliente.setText(null);
                        createAndShowGUI(3);
                    }
                }
            }
        });
        buttonCancel.addActionListener(e -> this.setVisible(false));

    }

    /**
     * Método para gerar e mostrar o JFrame FrameCadastrar
     * @author Pedro Henrique Braga de Morais
     * @since FrameCadastrar v1.0
     * @see controller.ControleOrcamentos
     * @see controller.ControleProduto
     * @see controller.ControleClientes
     * @param op
     * @returns void
     */
    public void createAndShowGUI(int op){

        setBounds(720,270,480,540);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);
        switch (op) {
            case 1 -> {
                this.op = op;
                //TituloOrcamento
                tituloOrcamento = new JTextField();
                tituloOrcamento.setBounds(30, 40, 420, 30);
                add(tituloOrcamento);
                JPanel panelTituloOrcamento = new JPanel();
                panelTituloOrcamento.setBounds(20, 20, 440, 60);
                add(panelTituloOrcamento);
                panelTituloOrcamento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Titulo Orçamento"));
                //valor
                valorOrcamento = new JTextField();
                valorOrcamento.setText("0");
                valorOrcamento.setBounds(30, 110, 420, 30);
                add(valorOrcamento);
                JPanel panelValorOrcamento = new JPanel();
                panelValorOrcamento.setBounds(20, 90, 440, 60);
                add(panelValorOrcamento);
                panelValorOrcamento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Valor Orcamento"));
                //descricao
                descricaoOrcamento = new JTextArea();
                descricaoOrcamento.setBounds(30, 180, 420, 100);
                descricaoOrcamento.setLineWrap(true);
                descricaoOrcamento.setBorder(valorOrcamento.getBorder());//Mesma borda dos outros painéis
                add(descricaoOrcamento);
                JPanel panelDescricaoOrcamento = new JPanel();
                panelDescricaoOrcamento.setBounds(20, 160, 440, 130);
                add(panelDescricaoOrcamento);
                panelDescricaoOrcamento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Descrição Orcamento"));

                //clientes
                clientesJComboBox = new JComboBox<>(telaInicio.controleClientes.toStringNomeClientes().toArray(new String[telaInicio.controleClientes.getNumClientes()]));
                JPanel panelClientes = new JPanel();
                panelClientes.setLayout(null);
                panelClientes.setBounds(20, 300, 440, 59);
                panelClientes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Cliente"));
                panelClientes.add(clientesJComboBox);
                clientesJComboBox.setBounds(10, 17, 420, 25);
                add(panelClientes);

                //produtos
                produtosJComboBox = new JComboBox<>(telaInicio.controleProduto.toStringNomeProdutos().toArray(new String[telaInicio.controleProduto.getNumProdutos()]));
                JPanel panelProdutos = new JPanel();
                panelProdutos.setLayout(null);
                panelProdutos.setBounds(20, 370, 440, 59);
                panelProdutos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Produtos"));
                panelProdutos.add(produtosJComboBox);
                produtosJComboBox.setBounds(10, 17, 420, 25);
                add(panelProdutos);
            }
            case 2 -> {
                this.op = op;
                //valor Produto
                valorProduto = new JTextField();
                valorProduto.setBounds(30, 40, 420, 30);
                add(valorProduto);
                JPanel panelvalorProduto = new JPanel();
                panelvalorProduto.setBounds(20, 20, 440, 60);
                add(panelvalorProduto);
                panelvalorProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Valor Produto"));

                //nome Produto
                nomeProduto = new JTextField();
                nomeProduto.setBounds(30, 120, 420, 30);
                add(nomeProduto);
                JPanel panelnomeProduto = new JPanel();
                panelnomeProduto.setBounds(20, 100, 440, 60);
                add(panelnomeProduto);
                panelnomeProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Nome Produto"));

                //descricao Produto
                descricaoProduto = new JTextArea();
                descricaoProduto.setBounds(30, 200, 420, 100);
                descricaoProduto.setLineWrap(true);
                descricaoProduto.setBorder(nomeProduto.getBorder());
                add(descricaoProduto);
                JPanel paneldescricaoProduto = new JPanel();
                paneldescricaoProduto.setBounds(20, 180, 440, 130);
                add(paneldescricaoProduto);
                paneldescricaoProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Descrição Produto"));

                //tipo Produto
                tipoProduto = new JTextField();
                tipoProduto.setBounds(30, 340, 420, 30);
                add(tipoProduto);
                JPanel paneltipoProduto = new JPanel();
                paneltipoProduto.setBounds(20, 320, 440, 60);
                add(paneltipoProduto);
                paneltipoProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Tipo Produto"));

                //quantidade Produto
                quantidadeProduto = new JTextField();
                quantidadeProduto.setBounds(30, 410, 420, 30);
                add(quantidadeProduto);
                JPanel panelquantidadeProduto = new JPanel();
                panelquantidadeProduto.setBounds(20, 390, 440, 60);
                add(panelquantidadeProduto);
                panelquantidadeProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Quantidade Produto"));
            }
            case 3 -> {
                this.op = op;
                //Nome Cliente
                nomeCliente = new JTextField();
                nomeCliente.setBounds(30, 40, 420, 30);
                add(nomeCliente);
                JPanel panelNomeCliente = new JPanel();
                panelNomeCliente.setBounds(20, 20, 440, 60);
                add(panelNomeCliente);
                panelNomeCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Nome Cliente"));
                //email
                emailCliente = new JTextField();
                emailCliente.setBounds(30, 110, 420, 30);
                add(emailCliente);
                JPanel panelEmailCliente = new JPanel();
                panelEmailCliente.setBounds(20, 90, 440, 60);
                add(panelEmailCliente);
                panelEmailCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Email Cliente"));
                //Cpf ou cnpj
                cpf_cnpjCliente = new JTextField();
                cpf_cnpjCliente.setBounds(30, 180, 420, 30);
                add(cpf_cnpjCliente);
                JPanel panelCPFCNPJCliente = new JPanel();
                panelCPFCNPJCliente.setBounds(20, 160, 440, 60);
                add(panelCPFCNPJCliente);
                panelCPFCNPJCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Cpf/Cnpj Cliente"));

                //É PJ ou PF?
                isPJCliente = new JCheckBox("É PJ?");
                isPJCliente.setBounds(30, 230, 100, 30);
                isPFCliente = new JCheckBox("É PF?");
                isPFCliente.setBounds(130, 230, 100, 30);
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
                ddCliente = new JTextField();
                ddCliente.setBounds(30, 300, 27, 30);
                telCliente = new JTextField();
                telCliente.setBounds(67, 300, 100, 30);
                JPanel panelDdTelCliente = new JPanel();
                panelDdTelCliente.setBounds(20, 280, 440, 60);
                add(ddCliente);
                add(telCliente);
                add(panelDdTelCliente);
                panelDdTelCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "DD + Telefone Cliente"));

                //endereço cliente
                enderecoCliente = new JTextField();
                enderecoCliente.setBounds(30, 380, 420, 30);
                add(enderecoCliente);
                JPanel panelEnderecoCliente = new JPanel();
                panelEnderecoCliente.setBounds(20, 360, 440, 60);
                add(panelEnderecoCliente);
                panelEnderecoCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY), "Endereço Cliente"));
            }
        }
        
        setResizable(false);
        buttonOk.setBounds(280,470,60,30);
        add(buttonOk);
        buttonCancel.setBounds(350,470,120,30);
        add(buttonCancel);
        setVisible(true);

    }
}
