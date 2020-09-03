package br.com.prog2.heranca1;

public class Ingresso {
	Double valor;
	protected String local;
	
	public Ingresso(Double valor){
		this.valor=valor;
	}
	
	public String imprime(){
		return "Ingresso ";
	}
	
}
