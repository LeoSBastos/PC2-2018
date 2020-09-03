package br.com.prog2.aula09;

public class TesteExcecao2 {

	public static void main(String[] args) {
		int num1 = 6;
		int num2 = 7;
		try {
			if((num1-num2)<0){
				throw new ResultadoNegativoException(num1, num2);
			}
		} catch (ResultadoNegativoException e){
			System.out.println(e.toString());
		}
	}

}
