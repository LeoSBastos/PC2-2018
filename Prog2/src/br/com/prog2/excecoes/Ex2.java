package br.com.prog2.excecoes;

import javax.swing.JOptionPane;

public class Ex2 {
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero n"));
		try {
			int[] v = new int[n];
		} catch (NegativeArraySizeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Criado um array");
		}
	}
	
	
}
