package br.com.prog2.aula06;

public class Array1 {
	public static void main(String[] args) {
		int[] numeros = new int[5];
		Integer[] numerosInteger = new Integer[3];
		String[] nomes = new String[4];
		Curso[] listaDeCursos = new Curso[6];
	
		
		System.out.println(numeros.length);
		System.out.println(numerosInteger.length);
		System.out.println(nomes.length);
		System.out.println(listaDeCursos.length);
		
		for(int i = 0; i < numeros.length;i++){
			System.out.println(numeros[i]);
		}
	
		
	
	
	
	
	}
}
