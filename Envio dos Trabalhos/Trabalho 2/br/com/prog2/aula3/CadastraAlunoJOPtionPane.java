package br.com.prog2.aula3;

import javax.swing.JOptionPane;

import br.com.prog2.util.DataPadraoBrasil;

public class CadastraAlunoJOPtionPane {

	public static void main(String[] args) {
	
		
		String matricula = JOptionPane.showInputDialog("Digite a matricula");
		String nome = JOptionPane.showInputDialog("Digite o nome");
		
		String dia = JOptionPane.showInputDialog("Digite o dia");
		String mes = JOptionPane.showInputDialog("Digite o mes");
		String ano = JOptionPane.showInputDialog("Digite o ano");

			
		DataPadraoBrasil dataDeNascimento = new DataPadraoBrasil(dia,mes,ano);
		Aluno aluno = new Aluno(Integer.parseInt(matricula),nome,dataDeNascimento);
		
		JOptionPane.showMessageDialog(null, "Aluno: "+aluno.nome+ "\nMatricula:"+aluno.matricula+"\nData de nascimento: "+dataDeNascimento.toString());
		
	}

}
