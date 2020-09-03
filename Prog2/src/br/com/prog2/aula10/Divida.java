package br.com.prog2.aula10;

import java.time.LocalDate;

public class Divida {
	private Integer codigo;
	private Double valor;
	private LocalDate dataContato;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public LocalDate getDataContato() {
		return dataContato;
	}
	public void setDataContato(LocalDate dataContato) {
		this.dataContato = dataContato;
	}
	
	@Override
	public String toString() {
		return "Codigo: "+codigo+"\nValor: "+valor+"\nData de Contato: "+dataContato;
	}
}
