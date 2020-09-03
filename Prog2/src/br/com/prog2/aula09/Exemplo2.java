package br.com.prog2.aula09;


public class Exemplo2 {

	public static void main(String[] args) {
		int[] vet = new int[3];
		try {
			for(int c = 0;c < 4; c++){
				vet[c] = 0;
			}
		}finally {
			System.out.println("Entrada garantida");
		}
		System.out.println("Fim do programa.");
	}
}
