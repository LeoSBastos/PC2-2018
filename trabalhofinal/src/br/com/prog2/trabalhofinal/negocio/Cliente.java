package br.com.prog2.trabalhofinal.negocio;

import java.time.LocalDate;

public class Cliente {
	private Integer codCliente;
	private String nomeCliente;
	private String rgCliente;
	private String enderecoCliente;
	private String bairroCliente;
	private String cidadeCliente;
	private String estadoCliente;
	private String CepCliente;
	private LocalDate nascimentoCliente;
	
	public Cliente() {
	}
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	public String getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	public String getCepCliente() {
		return CepCliente;
	}
	public void setCepCliente(String cepCliente) {
		CepCliente = cepCliente;
	}
	public LocalDate getNascimentoCliente() {
		return nascimentoCliente;
	}
	public void setNascimentoCliente(LocalDate nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}
	
}
