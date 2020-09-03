package br.com.prog2.aula04;

import java.text.NumberFormat;
import java.util.Locale;

public class FormataNumero {

	public static void main(String[] args) {
		double valor = 789.6767213234234;
		System.out.println(valor);
		Locale n = new Locale("en","GB");
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(n);
		System.out.println(nf.format(valor));
		n = new Locale ("it","IT");
		NumberFormat nf1 = NumberFormat.getCurrencyInstance(n);
		System.out.println(nf1.format(valor));
		n = new Locale ("en","US");
		NumberFormat nf2 = NumberFormat.getCurrencyInstance(n);
		System.out.println(nf2.format(valor));
		n = new Locale ("ja","JP","JP");
		NumberFormat nf3 = NumberFormat.getCurrencyInstance(n);
		System.out.println(nf3.format(valor));
		n = new Locale ("zh","CH","CH");
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(n);
		System.out.println(nf4.format(valor));
		
	}

}
