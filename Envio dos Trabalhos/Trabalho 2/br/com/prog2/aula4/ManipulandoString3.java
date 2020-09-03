package br.com.prog2.aula4;

public class ManipulandoString3 {

	public static void main(String[] args) {
		// a
		String s = "Programacao de Computadores II";
		System.out.println(s.length());
		// b
		char c = s.charAt(6);
		System.out.println(c);
		// c
		String s1 = new String("AAA");
		String s2 = new String("AAA");
		if (s1.equals(s2)) {
			System.out.println("São iguais");
		} else {
			System.out.println("São diferentes");
		}
		// d
		s1 = "aAA";
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("São iguais");
		} else {
			System.out.println("São diferentes");
		}
		// e
		s1 = "A";
		s2 = "B";
		int res = s1.compareTo(s2);
		System.out.println(res);
		// f
		s1 = "A";
		s2 = "a";
		res = s1.compareToIgnoreCase(s2);
		System.out.println(res);
		// g
		String sub = s.substring(12);
		System.out.println(sub);
		// h
		String novaS = s.replace('r', 'l');
		System.out.println(novaS);
		// i
		int posicao = s.indexOf('a');
		System.out.println(posicao);
		// j
		posicao = s.lastIndexOf('a');
		System.out.println(posicao);
		// k
		String novaString = s.toUpperCase();
		System.out.println(novaString);
		// l
		novaString = s.toLowerCase();
		System.out.println(novaString);
		// m
		novaString = s.trim();
		System.out.println(novaString);
		// n
		boolean verd = s.startsWith("com");
		System.out.println(verd);
		// o
		verd = s.endsWith("res");
		System.out.println(verd);
		// p
		s = "Nome,Endereço,UF,CEP";
		String[] cabecalho = s.split(",");
		System.out.println(cabecalho[0]);
		System.out.println(cabecalho[1]);
		System.out.println(cabecalho[2]);
		System.out.println(cabecalho[3]);

	}

}
