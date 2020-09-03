package br.com.prog2.trabalho7;

import java.io.*;

import javax.swing.JOptionPane;

public class Ex1 {
	public static void main(String[] args) {
		String nomeentrada;
		String nomesaida;
		String nota;
		String nome;
		String nextline = "\n";
		nomeentrada = JOptionPane.showInputDialog("Digite o nome do arquivo entrada") + ".txt";
		nomesaida = JOptionPane.showInputDialog("Digite o nome do arquivo de saida") + ".txt";
		File arquivosaida = new File(nomesaida);
		BufferedReader arquivoentrada = null;

		try {
			arquivoentrada = new BufferedReader(new FileReader(nomeentrada));
			FileOutputStream fos = new FileOutputStream(arquivosaida);

			while (arquivoentrada.ready()) {
				nome = arquivoentrada.readLine() + " ";
				nota = JOptionPane.showInputDialog(nome + "Digite a nota deste aluno");
				fos.write(nome.getBytes());
				fos.write(nota.getBytes());
				fos.write(nextline.getBytes());
			}
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				arquivoentrada.close();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
