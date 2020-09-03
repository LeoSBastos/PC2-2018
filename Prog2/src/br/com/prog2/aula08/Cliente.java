package br.com.prog2.aula08;

public abstract class Cliente {
	private Integer codigo;
	private	String nome;
	private	String endereco;
	private String uf;
	private	String cep;
	
	public Cliente(Integer codigo, String nome, String endereco, String uf, String cep) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.uf = uf;
		this.cep = cep;
	}
	public abstract void inserir();
	public abstract void alterar();
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

}
