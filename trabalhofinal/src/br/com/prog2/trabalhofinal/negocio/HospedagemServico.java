package br.com.prog2.trabalhofinal.negocio;

import java.time.LocalDate;

public class HospedagemServico {
	private Integer codHospedagem;
	private LocalDate dataServico;
	private Integer codServico;
	private Double valorServico;
	public HospedagemServico() {
	}
	public Integer getCodHospedagem() {
		return codHospedagem;
	}
	public void setCodHospedagem(Integer codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	public LocalDate getDataServico() {
		return dataServico;
	}
	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
	}
	public Integer getCodServico() {
		return codServico;
	}
	public void setCodServico(Integer codServico) {
		this.codServico = codServico;
	}
	public Double getValorServico() {
		return valorServico;
	}
	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}
}
