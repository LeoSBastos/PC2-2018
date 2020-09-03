package br.com.prog2.trabalho7;

import java.io.*;

import javax.swing.JOptionPane;

public class Ex2 {
	public static void main(String[] args) {
		String nomearquivo;
		String linha;
		nomearquivo = JOptionPane.showInputDialog("Digite o nome do arquivo entrada") + ".txt";
		BufferedReader arquivo = null;
		try {
			arquivo = new BufferedReader(new FileReader(nomearquivo));
			while (arquivo.ready()) {
				linha = arquivo.readLine();
				linha = linha.replaceAll("r", "");
				linha = linha.replaceAll("R", "");
				linha = linha.replaceAll("l", "u");
				linha = linha.replaceAll("L", "U");

				System.out.println(linha);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				arquivo.close();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}