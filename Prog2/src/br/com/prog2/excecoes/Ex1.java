package br.com.prog2.excecoes;

public class Ex1 {
	public static void main(String[] args) {
		int x = (int) (Math.random()*5);
		int y = (int) (Math.random()*10);
		try {
			System.out.println("x/y = " + (y/x));
		} catch (ArithmeticException e) {
			System.out.println("Problemas Aritméticos "+e.getMessage());
			e.printStackTrace();
		}
	}
}
