package br.com.prog2.trabalhofinal.negocio;

public class Telefone {
	private String telefone;
	private Integer codCliente;
	private Integer tipoTelefone;
	public Telefone() {
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public Integer getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(Integer tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
}
