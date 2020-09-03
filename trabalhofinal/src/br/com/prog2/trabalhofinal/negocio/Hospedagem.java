package br.com.prog2.trabalhofinal.negocio;

import java.time.LocalDate;

public class Hospedagem {
	private Integer codHospedagem;
	private Integer codChale;
	private Integer codCliente; 
	private Integer	estado;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer qtdPessoas;
	private Double desconto;
	private Double valorFinal;
	public Hospedagem() {
	}
	public Integer getCodHospedagem() {
		return codHospedagem;
	}
	public void setCodHospedagem(Integer codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	public Integer getCodChale() {
		return codChale;
	}
	public void setCodChale(Integer codChale) {
		this.codChale = codChale;
	}
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public Integer getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}	
}
