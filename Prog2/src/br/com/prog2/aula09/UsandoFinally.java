package br.com.prog2.aula09;

public class UsandoFinally {

	public static void main(String[] args) {
		int x = 10;
		int y = 0;
		try{
			System.out.println(x/y);
		} catch (ArithmeticException e) {
			System.out.println();
		} finally {
			System.out.println("Finally Executado");
		}
	}
}
