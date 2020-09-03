package br.com.prog2.heranca1;

import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		Administrativo a1 = new Administrativo("Dermevaldo", "1", "dia");
		Tecnico a2 = new Tecnico("Eloy", "2");
		
		System.out.println(a1.exibeDados());
		System.out.println(a2.exibeDados());
		
		Cachorro c1 = new Cachorro();
		System.out.println(c1.late());
		Gato g1 = new Gato();
		System.out.println(g1.mia());
		System.out.println(c1.caminha());
		System.out.println(g1.caminha());

		Rica p1 = new Rica();
		Pobre p2 = new Pobre();
		Miseravel p3 = new Miseravel();

		System.out.println(p1.fazCompras());
		System.out.println(p2.trabalha());
		System.out.println(p3.mendiga());


		Integer i = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para ingresso normal e 2 para VIP"));
		if (i == 1){
			Normal n = new Normal(15.0);
			System.out.println(n.imprime());
		}
		else if (i==2){
			i = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para Camarote Inferior e 2 para Camarote Superior"));
			if (i==1){
				CamaroteInferior ci = new CamaroteInferior(10.0,5.0,"J23");
				System.out.println(ci.imprime());
			}
			else if(i==2){
				CamaroteSuperior cs = new CamaroteSuperior(10.0,10.0);
				System.out.println(cs.imprime());
			}
			else {
				System.out.println("Numero invalido!");
			}
		}
		else {
			System.out.println("Numero invalido!");
		}

		Integer j = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para um imovel novo e 2 para um velho"));
		if(j==1) {
			Novo no = new Novo(2000.0);
			no.setAdicional(15.0);
			System.out.println(no.getTotal());
		}
		else if (j==2){
			Velho ve = new Velho(1500.0);
			ve.setDesconto(15.0);
			System.out.println(ve.getTotal());
		}
		else{
			System.out.println("Numero invalido!");
		}
	}
}
