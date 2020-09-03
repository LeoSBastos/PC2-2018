package br.com.prog2.heranca1;

public class CamaroteInferior extends VIP {
	
	public CamaroteInferior(Double valor, Double valoradicional, String local) {
		super(valor, valoradicional);
		setLocal(local);
	}
	
	public void setLocal(String local){
		super.local=local;
	}
	public String getLocal() {
		return super.local;
	}
	
	@Override
	public String imprime() {
		return super.imprime()+"Camarote Inferior: "+valor+"\nLocal: "+getLocal();
	}
}
