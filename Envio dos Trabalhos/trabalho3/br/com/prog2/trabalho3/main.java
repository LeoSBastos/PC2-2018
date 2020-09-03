package br.com.prog2.trabalho3;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		String s1;
		String s2;
		Double d1;
		Integer i1;
		Salario sa;
		s1 = JOptionPane.showInputDialog("Digite o salario bruto ou digite 0 para cancelar:");
		d1 = Double.parseDouble(s1);
		while (d1 != 0.0) {
			s2 = JOptionPane.showInputDialog("Digite o dependentes: ");
			i1 = Integer.parseInt(s2);
			sa = new Salario(d1, i1);
			sa.calculaINSS();
			sa.calculaDescontoDependentes();
			sa.calculaIRPF();
			sa.calculaLiquido();
			System.out.println(sa.toString());
			s1 = JOptionPane.showInputDialog("Digite o salario bruto ou digite 0 para cancelar:");
			d1 = Double.parseDouble(s1);
		}

	}
}