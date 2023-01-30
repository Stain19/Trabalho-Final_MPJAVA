package model;

/**
 * Classe Usuário que herda a classe Pessoa
 * @deprecated
 * @autor Pedro Henrique Braga
 * @since 30/11/2022
 * @version 1.0
 */
public class Usuario extends Pessoa {
	private int id;
	private String senha;
	
	Usuario(String nome,String email,String cpf_cnpj,boolean isPFPJ,Telefone numTel,int id, String senha) {
		this.nome = nome;
		this.email = email;
		this.cpf_cnpj = cpf_cnpj;
		this.isPFPJ = isPFPJ;
		this.numTel = numTel;
		this.id = id;
		this.senha = senha;
	}

	/**
	 * Método utilizado para definir o ID do usuário
	 * @since v1.0
	 * @param ID
	 */
	public void setID( int ID ) {
		this.id = ID;
	}

	/**
	 * Método utilizado para retornar o ID do usuário
	 * @since v1.0
	 * @return int
	 */
	public int getID() {
		return id;
	}

	/**
	 * Método utilizado para definir a senha do usuário
	 * @since v1.0
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Método utilizado para retornar a senha do Usuário
	 * @since v1.0
	 * @return String
	 */
	public String getSenha() {
		return senha;
	}
}
