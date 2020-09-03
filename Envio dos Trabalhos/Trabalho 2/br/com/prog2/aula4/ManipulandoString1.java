package br.com.prog2.aula4;

public class ManipulandoString1 {

	public static void main(String[] args) {
		String s1 = "Eloy ";
		String s2 = "é ";
		/*
		String s1 = new String("EloyVSF");
		String s2 = "EloyVSF";
		System.out.println("Usando ==: " + (s1==s2));
		
		System.out.println("Usando equals: '"+(s1.equals(s2)));*/
		
		String disciplina1 = "Programação de computadores II";
		//String disciplina2 = "Sistemas Multimidia";
		System.out.println(disciplina1.length());
		System.out.println(disciplina1.charAt(5));
		
		System.out.println(s1+s2+disciplina1.substring(18,22));
	
	}

}
