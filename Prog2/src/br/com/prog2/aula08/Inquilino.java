package br.com.prog2.aula08;

public class Inquilino extends Morador {
	private Integer tempoContrato;
	
	public Integer getTempoContrato() {
		return tempoContrato;
	}
	
	public void setTempoContrato(Integer tempoContrato) {
		this.tempoContrato = tempoContrato;
	}
	
	@Override
	public double calcularTaxaDeposito(int qtdeVolume) {
		return qtdeVolume*5.0;
	}

}
