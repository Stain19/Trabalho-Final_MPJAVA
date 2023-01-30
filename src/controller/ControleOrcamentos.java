package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Produto;
import model.Orcamento;


/**
 * Classe ControleOrcamentos é utilizada para Criar,Atualizar,Listar e Deletar as intanciações da classe Orcamentos.
 * @see Orcamento
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class ControleOrcamentos {
	private ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
	private int numOrcamentos;
	
	public ControleOrcamentos() {}

	/**
	 * Método utilizado para definir o Numero de Orcamentos
	 * @deprecated
	 * @since v1.0
	 * @param num
	 */
	public void setNumOrcamentos(int num) {
		this.numOrcamentos = num;
	}

	/**
	 * Método utilizado para definir o número de Orçamentos
	 * @since v1.0
	 * @return int
	 */
	public int getNumOrcamentos() {
		return numOrcamentos;
	}

	/**
	 * Método utilizado para retornar um vetor que contem os orcamentos
	 * @deprecated
	 * @since v1.0
	 * @return ArrayList<Orçamento>
	 */
	public ArrayList<Orcamento> getOrcamentos(){
		return orcamentos;
	}

	/**
	 * Método utilizado para cadastrar um orcamento
	 * @since v1.0
	 * @param con
	 * @param con1O
	 * @param indexCliente
	 * @param tituloOrcamento
	 * @param valorTotal
	 * @param descricao
	 * @return boolean
	 */
	public boolean cadastrarOrcamento(ControleClientes controleClientesC, ControleProduto conP, int indexCliente, String tituloOrcamento, double valorTotal, String descricao) {
		Orcamento oc = new Orcamento(tituloOrcamento, valorTotal, descricao, controleClientesC.retornarCliente(indexCliente));
		orcamentos.add(oc);
		numOrcamentos++;
		return true;
	}

	/**
	 * Método utilizado para adicionar um objeto Produto ao vetor produtos dentro do Orcamento
	 * @see Produto
	 * @since v1.0
	 * @param con2
	 * @param indexProduto
	 * @param indexOrcamento
	 */
	public void adicionarProduto(ControleProduto con2, int indexProduto, int indexOrcamento) {
		Produto produtoASerAdicionado = con2.retornarProduto(indexProduto);
		orcamentos.get(indexOrcamento).adicionarProduto(produtoASerAdicionado);
	}

	/**
	 * Método utilizado para remover um objeto Produto ao vetor produtos dentro do Orcamento
	 * @see Produto
	 * @since v1.0
	 * @param con2
	 * @param indexProduto
	 * @param indexOrcamento
	 */
	public void removerProduto(ControleProduto con2, int indexProduto, int indexOrcamento) {
		Produto produtoASerRemovida = con2.retornarProduto(indexProduto);
		orcamentos.get(indexOrcamento).removerProduto(produtoASerRemovida);
	}

	/**
	 * Método utilizado para listar os Orçamentos presentes dentro do vetor orcamentos
	 * @see Orcamento
	 * @since v1.0
	 * @return
	 */
	public String listarOrcamentos() {
		String s = "";
		int i = 1;
		for (Orcamento o : orcamentos) {
			s += "----------------------------------------"+"Orcamento "+(i)+"-----------------------------------\n"+o.toString()+"\n";
			i++;
		}
		return s;
	}

	/**
	 * Método utilizado para editar um orcamento específico dentro do vetor orcamentos
	 * @see Orcamento
	 * @since v1.0
	 * @param indexOrcamento
	 * @param novoTituloOrcamento
	 * @param novaDescricaoOrcamento
	 * @param novoCliente
	 * @return boolean
	 */
	public boolean editarOrcamento(int indexOrcamento,String novoTituloOrcamento,String novaDescricaoOrcamento,Cliente novoCliente) {
		orcamentos.get(indexOrcamento).setTituloOrcamento(novoTituloOrcamento);
		orcamentos.get(indexOrcamento).setDescricao(novaDescricaoOrcamento);
		orcamentos.get(indexOrcamento).setCliente(novoCliente);
		return true;
	}

	/**
	 * Método utilizado para excluir um orcamento específico dentro do vetor orcamentos
	 * @see Orcamento
	 * @since v1.0
	 * @param indexOrcamento
	 * @return boolean
	 */
	public boolean deletarOrcamento(int indexOrcamento) {
		try {
			orcamentos.remove(indexOrcamento);
			numOrcamentos--;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Método utilizado para retornar os titulos do orcamentos
	 * @see Orcamento
	 * @since v1.0
	 * @return ArrayList
	 */
	public ArrayList<String> toStringNomeOrcamentos(){
		ArrayList<String> nomesOrcamentos= new ArrayList<String>();
		for (Orcamento orcamento : orcamentos) {
			nomesOrcamentos.add(orcamento.getTituloOrcamento());
		}
		return nomesOrcamentos;
	}

	/**
	 * Método utilizado para retornar o index de um determinado orcamento dentro do vetor orcamentos
	 * @see Orcamento
	 * @since v1.0
	 * @param name
	 * @return int
	 */
	public int getOrcamentoIndex(String name){
		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getTituloOrcamento().equals(name)) {
				return orcamentos.indexOf(orcamento);
			}
		}

		return 0;
	}

	/**
	 * Método utilizado para retornar um determinado orcamento,de acordo com o index, dentro do vetor orcamentos
	 * @see Orcamento
	 * @since v1.0
	 * @param index
	 * @return Orcamento
	 */
	public Orcamento retornarOrcamento(int index){
		return orcamentos.get(index);
	}
}
