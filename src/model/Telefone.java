package model;

/**
 * Classe Telefone serve de parâmetro para a Classe Pessoa
 * @see Pessoa
 * @see Cliente
 * @see Usuario
 * @autor Pedro Henrique Braga
 * @since 30/11/2022
 * @version 1.0
 */
public class Telefone {
	private int dd;
	private int numero;
	
	public Telefone(int dd, int numero) {
		this.dd = dd;
		this.numero = numero;
	}

	/**
	 * Método que serve para definir o DD do telefone
	 * @since v1.0
	 * @param dd
	 */
	public void setDD(int dd) {
		this.dd = dd;
	}

	/**
	 * Método que serve para retornar o DD do Telefone
	 * @since v1.0
	 * @return int
	 */
	public int getDD() {
		return dd;
	}

	/**
	 * Método que serve para definir o número do Telefone
	 * @since v1.0
	 * @deprecated
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Método que serve para retornar o número do Telefone
	 * @since v1.0
	 * @return int
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Método que serve para retornar uma String sobre o Telefone
	 * @return String
	 */
	public String toString() {
		return "Telefone: "+dd+" "+numero;
	}
}
