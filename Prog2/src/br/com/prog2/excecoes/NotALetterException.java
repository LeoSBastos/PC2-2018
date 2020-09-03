package br.com.prog2.excecoes;

public class NotALetterException extends Exception{
	private static final long serialVersionUID = 1L;
	private char char1;
	public NotALetterException(char char1) {
		super();
		this.char1 = char1;
	}
	
	@Override
	public String toString() {
		return char1+" nao é uma letra.";
	}
}
