package br.com.prog2.heranca1;

public class Normal extends Ingresso{
	public Normal(Double valor) {
		super(valor);
	}
	
	@Override
	public String imprime() {
		return super.imprime()+"Normal: "+this.valor;
	}
}
