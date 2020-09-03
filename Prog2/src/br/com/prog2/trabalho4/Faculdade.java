package br.com.prog2.trabalho4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Faculdade {

	public static void main(String[] args) {
		ArrayList<Professor> ar1 = new ArrayList<Professor>();
		ArrayList<ContraCheque> ar2 = new ArrayList<ContraCheque>();
		String sair = "y";

		while (sair.equalsIgnoreCase("y")) {
			Professor teste1 = new Professor();
			ContraCheque teste2 = new ContraCheque();
			teste1.nome = (JOptionPane.showInputDialog("Digite o nome do professor"));
			teste1.ctps = (JOptionPane.showInputDialog("Digite o ctps do professor"));
			teste1.formacao = (JOptionPane.showInputDialog("Digite a formacao do professor"));
			teste2.vlha = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da hora aula"));
			teste2.nh = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de horas semanais"));
			teste2.dependentes = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de dependentes"));
			teste2.qhn = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de horas noturnas"));
			teste2.toCalcular();

			ar1.add(teste1);
			ar2.add(teste2);
			sair = JOptionPane.showInputDialog("Digite n para sair ou y para continuar");
		}

		for (int i = 0; i < ar1.size(); i++) {
			System.out.println(ar1.get(i));
			System.out.println(ar2.get(i));
		}
	}
}