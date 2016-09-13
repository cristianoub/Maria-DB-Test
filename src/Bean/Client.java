package Bean;

import java.math.BigInteger;

public class Client 
{
	/**
	 * Nossas variaveis de cliente Nào esquer da validacao do CNPJ no futuro
	 */
	String nome;
	int cnpj;
	String endereco;
	int telefone;
	String email;
	
	/**
	 * Gets and Sets
	 */
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int i) {
		this.telefone = i;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
