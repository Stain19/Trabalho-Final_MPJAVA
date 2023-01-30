package model;
/**
 *Classe Cliente herda da classe abstrata Pessoa e se refere a quem irá receber o produto/oferta
 *@autor Pedro Henrique Braga
 *@since 30/11/2022
 *@version 1.0
 */

public class Cliente extends Pessoa{
	private String endereco;
	public Cliente(String nome, String email, String cpfcnpj, boolean is, Telefone numTel, String endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf_cnpj = cpfcnpj;
		this.isPFPJ = is;
		this.numTel = numTel;
		this.endereco = endereco;
	}
	/**
	 * Altera o nome dado ao parametro endereco.
	 * @since v1.0
	 * @param nome
	 */
	public void setEndereco(String nome) {
		this.endereco = nome;
	}
	/**
	 * Retorna o valor do parametro endereco.
	 * @since v1.0
	 * @return String
	 * */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * Retorna um vetor de String contendo as informações sobre o cliente
	 * @since v1.0
	 * @return String
	 * */
	public String toString() {
		return "nome: "+nome+"\nEmail: "+email+"\ncpf/cnpj: "+cpf_cnpj+"\ntipo pessoa: "+(isPFPJ ? "PF" : "PJ")+"\nTelefone: "+numTel.getDD()+" "+numTel.getNumero()+"\nEndereco: "+endereco;
	}
}
