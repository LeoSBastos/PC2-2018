package br.com.prog2.aula09;

public class Exemplo1 {

	public static void main(String[] args) {
		int[] vet = new int[3];
		try {
			for(int c = 0;c < 4; c++){
				vet[c] = 0;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro no vetor!");
		} catch (Exception e){
			System.out.println("Houve um erro!");
		}
		System.out.println("Fim do programa.");
	}
}
