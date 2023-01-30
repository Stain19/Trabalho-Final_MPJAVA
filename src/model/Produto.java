package model;

/**
 * Classe Produto se refere ao produto cadastrado pelo usuário e presente no orcamento.É gerido pela classe controle produto.
 * @author Pedro Henrique Braga de Morais
 * @since 30/11/2022
 * @version v1.0
 */
public class Produto {
	private double preco;
	private String nome;
	private String descricao;
	private String tipo;
	private int quantidade;
	
	public Produto(double preco, String nome, String descricao, String tipo, int quantidade) {
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	/**
	 * Método utilizado para set Preco
	 * @since v1.0
	 * @param valor
	 */
	public void setPreco(double valor) {
		this.preco = valor;
	}

	/**
	 * Método utilizado para retornar Preco
	 * @return
	 */
	public double getPreco() {
		return preco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setDescricao(String texto) {
		this.descricao = texto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setQuantidade(int num) {
		this.quantidade = num;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public String toString() {
		return "Nome: "+nome+"\nPreco: "+preco+"\nDescricao: "+descricao+"\nTipo: "+tipo;
	}
}
