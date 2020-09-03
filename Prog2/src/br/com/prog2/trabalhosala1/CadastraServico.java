package br.com.prog2.trabalhosala1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CadastraServico {

	public static void main(String[] args) {
		ArrayList<Servico> arr = new ArrayList<>();
		String opcao = "S";
		String tru = "s";
		int i = 1;
		double total = 0;
		while(tru.compareToIgnoreCase(opcao)==0){
			Servico s = new Servico();
			s.setCodigo(i);
			i++;
			s.setDescricao(JOptionPane.showInputDialog("Qual a descriçao do servico?"));
			s.setPrecoHora(Double.parseDouble(JOptionPane.showInputDialog("Qual o preço hora?")));
			s.setQtdeHora(Integer.parseInt(JOptionPane.showInputDialog("Quantas horas foi o trabalho?")));
			arr.add(s);
			opcao = JOptionPane.showInputDialog("Para continuar digite S");
		}
		
		for(Servico s : arr){
			total+=s.valorServico();
		}
		
		System.out.println("CODIGO DESCRICAO VAL HORA QTE HORA VALOR");
		
		for(Servico s : arr){
			System.out.println(s.toString(s));
		}
		System.out.println("Total "+total);
	}

}
