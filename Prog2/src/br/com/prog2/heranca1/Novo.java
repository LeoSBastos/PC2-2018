package br.com.prog2.heranca1;

public class Novo extends Imovel{
	private Double adicional;
	public Novo(Double preco){
		super.preco=preco;
	}
	
	public void setAdicional(Double adicional) {
		this.adicional = this.preco * (adicional/100);
	}
	public Double getAdicional() {
		return adicional;
	}
	
	public Double getTotal(){
		return (preco+adicional);
	}
	
	public String imprime(){
		return "Pre�o: "+ getTotal();
	}
	
}
