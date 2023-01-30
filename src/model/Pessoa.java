package model;

/**
 * Classe Abstrata Pessoa serve de super classe para as Classes Usuário e Cliente
 * @see Usuario
 * @see Cliente
 * @autor Pedro Henrique Braga
 * @since 30/11/2022
 * @version 1.0
 */
public abstract class Pessoa {
	protected String nome;
	protected String email;
	protected String cpf_cnpj;
	protected boolean isPFPJ;
	protected Telefone numTel;
	
	
	public Pessoa() {
		super();
	}

	/**
	 * Método que serve para definir o nome da Pessoa
	 * @since v1.0
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que serve para retornar o nome da Pessoa
	 * @since v1.0
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que serve para definir o email da Pessoa
	 * @since v1.0
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método que serve para retornar o email da Pessoa
	 * @since v1.0
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método que serve para definir CPF ou CNPJ da Pessoa
	 * @since v1.0
	 * @param num
	 */
	public void setCpfCnpj(String num) {
		this.cpf_cnpj = num;
	}

	/**
	 * Método que serve para retornar CPF ou CNPJ da pessoa
	 * @since v1.0
	 * @return String
	 */
	public String getCPFCNPJ() {
		return cpf_cnpj;
	}

	/**
	 * Método que serve para definir se a Pessoa é PF ou PJ, sendo true para PF e false para PJ
	 * @since v1.0
	 * @param is
	 */
	public void setIsPFPJ(boolean is) {
		this.isPFPJ = is;
	}

	/**
	 * Método que serva para retornar se a Pessoa é PF ou PJ, sendo true para PF e false para PJ
	 * @since v1.0
	 * @return boolean
	 */
	public boolean getIsPFPJ() {
		return isPFPJ;
	}

	/**
	 * Método que serve para definir o Telefone da Pessoa
	 * @since v1.0
	 * @param num
	 */
	public void setNumTel(Telefone num) {
		this.numTel = num;
	}

	/**
	 * Método que retorna o telefone da Pessoa
	 * @since v1.0
	 * @return Telefone
	 */
	public Telefone getNumTel() {
		return numTel;
	}
}
