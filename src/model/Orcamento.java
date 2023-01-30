package model;

import java.util.ArrayList;

/**
 * Classe Orcamento serve de referencia para criação de Objetos orcamentos,tais objetos são de uso primordial no programa.
 * Cada instanciação da classe Orcamento contem suas próprias propriedades(titulo,valor,etc) e um ArrayList de produtos e
 * uma variável do tipo Cliente, que armazena o cliente deste orcamento.
 * @autor Pedro Henrique Braga
 * @since 30/11/2022
 * @version 1.0
 */
public class Orcamento {
	private String tituloOrcamento;
	private double valorTotal;
	private String descricao;
	private Cliente cliente;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Orcamento(String titulo, double valor,String descricao,Cliente cliente) {
		this.tituloOrcamento = titulo;
		this.valorTotal = valor;
		this.descricao = descricao;
		this.cliente = cliente;
	}

	/**
	 * Método que define o titulo do orçamento
	 * @since v1.0
	 * @param nome
	 */
	public void setTituloOrcamento(String nome) {
		this.tituloOrcamento = nome;
	}

	/**
	 * Método que retorna o titulo do orçamento
	 * @since v1.0
	 * @return String
	 */
	public String getTituloOrcamento() {
		return tituloOrcamento;
	}

	/**
	 * Método que define o valor Total do orçamento
	 * @since v1.0
	 * @param valor
	 */
	public void setValorTotal(double valor) {
		this.valorTotal = valor;
	}

	/**
	 * Método que retorna o valor total do orcamento
	 * @since v1.0
	 * @return double
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * Método que define a descrição do orçamento
	 * @since v1.0
	 * @param texto
	 */
	public void setDescricao(String texto) {this.descricao = texto;
	}

	/**
	 *Método que retorna a descrição do orçamento
	 * @since v1.0
	 * @return String
	 */
	public String getDescricao() {return descricao;}

	/**
	 * Método que define o Cliente do orçamento
	 * @since v1.0
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {this.cliente = cliente;}

	/**
	 * Método que retorna o Cliente do orçamento
	 * @since v1.0
	 * @return Cliente
	 */
	public Cliente getCliente() {return cliente;}

	/**
	 * Método utilizado para adicionar um produto ao arrayList produtos de um orçamento
	 * @see ArrayList
	 * @since v1.0
	 * @param produto
	 */
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
		valorTotal += produto.getPreco() * produto.getQuantidade();
	}

	/**
	 * Método utilizado para remover um produto do ArrayList produtos de um orçamento
	 * @see ArrayList
	 * @since v1.0
	 * @param produto
	 */
	public void removerProduto(Produto produto) {
		produtos.remove(produto);
		valorTotal -= produto.getPreco() * produto.getQuantidade();
	}

	/**
	 * Método utilizado para retornar uma String dos Produtos do orçamento
	 * @since v1.0
	 * @return String
	 */
	public String toStringProdutos() {
		String st = "";
		for (Produto o : produtos) {
			st += o.toString() + "\n------------------------------------------\n";
		}
		return st;
	}

	/**
	 * Método Utilizado para retornar uma String do orçamento
	 * @since v1.0
	 * @return String
	 */
	public String toString() {
		return "Titulo: "+tituloOrcamento+"\nvalor total: "+valorTotal+"\nDescricao: \n"+descricao+"\nCliente: "+cliente.getNome()+"\n_______________________________________________________________"+"\n\n**********************-Produtos-********************** \n"+ toStringProdutos();
	}
}
