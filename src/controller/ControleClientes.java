package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Telefone;

/**
 * Classe ControleClientes é utilizada para Criar,Atualizar,Listar e Deletar as intanciações da classe Cliente.
 * @see Cliente
 * @author Pedro Henrique Braga de Morais
 * @since 28/01/2023
 * @version v1.0
 */
public class ControleClientes {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int numClientes;
	
	
	public ControleClientes() {
	}

	/**
	 * Definir o numClientes
	 * @param num
	 * @since v1.0
	 */
	public void setNumClientes(int num) {
		this.numClientes = num;
	}

	/**
	 * Retornar o numClientes
	 * @deprecated
	 * @return int
	 * @since v1.0
	 */
	public int getNumClientes() {
		return numClientes;
	}

	/**
	 * Método utilizado para o registro de cliente
	 * @since v1.0
	 * @see Cliente
	 * @param nome
	 * @param email
	 * @param cpfcnpj
	 * @param is
	 * @param DD
	 * @param numTel
	 * @param endereco
	 * @return
	 */
	public boolean registrarCliente(String nome, String email, String cpfcnpj, boolean is,int DD,int numTel, String endereco) {
		Telefone telCliente = new Telefone(DD,numTel);
		Cliente cliente = new Cliente(nome,email,cpfcnpj,is,telCliente,endereco);
		clientes.add(cliente);
		numClientes++;
		return true;
	}

	/**
	 * Método utilizado para listagem de clientes na variavel clientes
	 * @return String
	 */
	public String listarClientes() {
		String s = "";
		int i = 1;
		for ( Cliente c : clientes) {
			s += "-------------------------------------------"+"Cliente "+(i)+"------------------------------------------\n"+c.toString()+"\n";
			i++;
			}
		return s;
	}

	/**
	 * Método utilizado para editarCLientes na variável clientes
	 * @since v1.0
	 * @param indexCliente
	 * @param novoNome
	 * @param novoEmail
	 * @param novoCPFCNPJ
	 * @param novoIsPFPJ
	 * @param novoNumTel
	 * @param novoEndereco
	 */
	public void editarClientes(int indexCliente, String novoNome,String novoEmail, String novoCPFCNPJ, boolean novoIsPFPJ,Telefone novoNumTel,String novoEndereco) {
		clientes.get(indexCliente).setNome(novoNome);
		clientes.get(indexCliente).setEmail(novoEmail);
		clientes.get(indexCliente).setCpfCnpj(novoCPFCNPJ);
		clientes.get(indexCliente).setIsPFPJ(novoIsPFPJ);
		clientes.get(indexCliente).setNumTel(novoNumTel);
		clientes.get(indexCliente).setNumTel(novoNumTel);
		clientes.get(indexCliente).setEndereco(novoEndereco);
	}

	/**
	 * Método Utilizado para deletar clientes na variável clientes
	 * @since v1.0
	 * @param indexCliente
	 */
	public void deletarCliente(int indexCliente) {
		clientes.remove(indexCliente);
	}

	/**
	 * Método utilizado para retornar determinado cliente na variavel clientes
	 * @see Cliente
	 * @since v1.0
	 * @param index
	 * @return Cliente
	 */
	public Cliente retornarCliente(int index) {
		return clientes.get(index);
	}
	public int getClientIndex(String name){
			for (Cliente cliente : clientes) {
				if (cliente.getNome().equals(name)) {
					return clientes.indexOf(cliente);
				}
			}

		return 0;
	}


	/**
	 * Método utilizado para retornar um toString do vetor clientes
	 * @see ArrayList
	 * @see Cliente
	 * @since v1.0
	 * @return ArrayList<String>
	 */
	public ArrayList<String> toStringNomeClientes() {
		ArrayList<String> nomesClientes= new ArrayList<String>();
		for (Cliente cliente : clientes) {
			nomesClientes.add(cliente.getNome());
		}
		return nomesClientes;
	}
}
