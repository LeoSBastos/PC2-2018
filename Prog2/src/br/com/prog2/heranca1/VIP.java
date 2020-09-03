package br.com.prog2.heranca1;

public class VIP extends Ingresso {
	double valoradicional;
	
	public VIP(Double valor, Double valoradicional) {
		super((valor+valoradicional));
	}
	
	@Override
	public String imprime() {
		return super.imprime()+"VIP ";
	}
}
