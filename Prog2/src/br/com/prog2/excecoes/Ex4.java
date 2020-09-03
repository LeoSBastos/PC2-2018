package br.com.prog2.excecoes;

import javax.swing.JOptionPane;

public class Ex4 {
	public static void testeExcecao1(Character c) throws NotALetterException {
		try {
			if (!Character.isLetter(c)) {
				throw new NotALetterException(c);
			}
		} catch (NotALetterException e) {
			e.printStackTrace();
		}
	}

	public static void testeExcecao2(char c) throws NotUpperCaseException {
		try {
			if (!Character.isUpperCase(c)) {
				throw new NotUpperCaseException(c);
			}
		} catch (NotUpperCaseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String s1 = JOptionPane.showInputDialog("Digite uma string");
		
		for (Character c : s1.toCharArray()){
			try{
			testeExcecao1(c);
			testeExcecao2(c);
			}catch(NotALetterException e){
				e.printStackTrace();
			}catch(NotUpperCaseException e){
				e.printStackTrace();
			}
		}
	}
}