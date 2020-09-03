package br.com.prog2.aula09;

public class ResultadoNegativoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private int num1;
	private int num2;
	
	public ResultadoNegativoException(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	@Override
	public String toString() {
		return num1+"-"+num2+" resulta em um número negativo.";
	}
}
