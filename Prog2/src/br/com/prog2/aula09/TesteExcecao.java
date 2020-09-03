package br.com.prog2.aula09;

public class TesteExcecao {
	public static void testarExcecao() throws NumeroParException{
		int numero = 7;
		try{
			if(numero%2 != 0){
				throw new NumeroParException("Número não é par");
			}
			System.out.println(numero+" é par.");
		} catch (NumeroParException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try{
			testarExcecao();
		} catch (NumeroParException e) {
			e.printStackTrace();
		}
	}

}
