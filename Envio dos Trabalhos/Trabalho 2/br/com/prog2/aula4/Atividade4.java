package br.com.prog2.aula4;

public class Atividade4 {

	public static void main(String[] args) {
		Pagamento p1 = new Pagamento(150);
		Pagamento p2 = new Pagamento(300);
		Pagamento p3 = new Pagamento(1000);
		Pagamento p4 = new Pagamento(2000);
		System.out.println(p1.valorAPagar(30));
		System.out.println(p2.valorAPagar(0));
		System.out.println(p3.valorAPagar(0));
		System.out.println(p4.valorAPagar(120));
	}

}
