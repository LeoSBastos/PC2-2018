package br.com.prog2.heranca1;

public class CamaroteSuperior extends VIP {
	public CamaroteSuperior(Double valor, Double valoradicional) {
		super(valor,valoradicional);
	}
	
	@Override
	public String imprime() {
		return super.imprime()+"Camarote Superior"+this.valor;
	}
	
}
