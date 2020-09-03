package br.com.prog2.heranca1;

public class Velho extends Imovel{
	private Double desconto;

	public Velho(Double preco) {
		super.preco=preco;
	}
	
	public void setDesconto(Double desconto) {
		this.desconto = this.preco + (desconto/100);
	}
	
	public Double getDesconto() {
		return desconto;
	}

	public Double getTotal(){
		return (preco-desconto);
	}
	
	public String imprime() {
		return "Pre�o: "+getTotal();
	}
	
}
