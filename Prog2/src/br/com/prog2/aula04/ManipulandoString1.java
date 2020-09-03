package br.com.prog2.aula04;

public class ManipulandoString1 {

	public static void main(String[] args) {
		String s1 = "AAAA";
		String s2 = "AAAA";
		if(s1==s2){
			System.out.println("� igual!");
		}
		else System.out.println("� diferente");
		s2 = "BBBB";
		if(s1==s2){
			System.out.println("� igual!");
		}
		else System.out.println("� diferente");
		
		
		
		/*
		String s1 = new String("EloyVSF");
		String s2 = "EloyVSF";
		System.out.println("Usando ==: " + (s1==s2));
		
		System.out.println("Usando equals: '"+(s1.equals(s2)));*/
		
		String disciplina1 = "Programa��o de computadores II";
		//String disciplina2 = "Sistemas Multimidia";
		System.out.println(disciplina1.length());
		System.out.println(disciplina1.charAt(5));
		
		System.out.println(s1+s2+disciplina1.substring(18,22));
	
	}

}
