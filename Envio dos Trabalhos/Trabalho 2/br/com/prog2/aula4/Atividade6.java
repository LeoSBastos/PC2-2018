package br.com.prog2.aula4;

public class Atividade6 {
	public static void main(String[] args) {
		//7.1
		String sValor = new String("23.67");
		Double dValor = Double.parseDouble(sValor);
		System.out.println(dValor);
		//7.2
		sValor = "23";
		Integer iValor = Integer.parseInt(sValor);
		System.out.println(iValor);
		//8.1
		dValor = 4.78;
		sValor = dValor.toString();
		System.out.println(sValor);
		//8.2
		iValor = 90;
		sValor = iValor.toString();
		System.out.println(sValor);
		//9.1
		int i = 678945;
		System.out.println(Integer.toHexString(i));
		//9.2
		System.out.println(Integer.toBinaryString(i));
		//9.3
		System.out.println(Integer.toOctalString(i));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
