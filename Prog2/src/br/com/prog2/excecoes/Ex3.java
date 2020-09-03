package br.com.prog2.excecoes;

import javax.swing.JOptionPane;

public class Ex3 {
	public static void main(String[] args) {
		String s1 = null;
		String s2 = JOptionPane.showInputDialog("Digite a segunda string");
	
		try {
			System.out.println(s1.compareTo(s2));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	
	}
}
