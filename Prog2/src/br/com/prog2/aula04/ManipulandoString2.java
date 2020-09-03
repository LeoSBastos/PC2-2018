package br.com.prog2.aula04;

public class ManipulandoString2 {
	
	public static void main(String[] args) {
	String s1 = new String();
	String s2 = new String();
	s1 = "AAAA";
	s2 = "AAAA";
	
	if(s1==s2){
		System.out.println("� igual!");
	}
	else System.out.println("� diferente");
	
	if(s1.equals(s2)){
		System.out.println("� igual!");
	}
	else System.out.println("� diferente");
	
	s2="BBBB";
	
	if(s1.equals(s2)){
		System.out.println("� igual!");
	}
	else System.out.println("� diferente");
	}

}
