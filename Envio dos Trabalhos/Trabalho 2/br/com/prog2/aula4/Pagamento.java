package br.com.prog2.aula4;

public class Pagamento {
	double valor;

	public Pagamento(double valor) {
		this.valor = valor;
	}

	public double valorAPagar(int diasatraso) {
		if (diasatraso != 0) {
			return this.valor + (0.02 * this.valor) + (0.00035 * diasatraso * this.valor);
		}
		else{
			return this.valor;
		}
	}
}