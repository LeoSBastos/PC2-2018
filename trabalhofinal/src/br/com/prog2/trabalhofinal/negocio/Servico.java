package br.com.prog2.trabalhofinal.negocio;

public class Servico {
	private Integer codServico;
	private String nomeServico;
	private Double valorServico;
	public Servico() {
	}
	public Integer getCodServico() {
		return codServico;
	}
	public void setCodServico(Integer codServico) {
		this.codServico = codServico;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public Double getValorServico() {
		return valorServico;
	}
	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}	
}
