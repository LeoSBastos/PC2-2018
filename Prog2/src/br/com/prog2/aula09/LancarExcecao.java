package br.com.prog2.aula09;

import java.io.IOException;

public class LancarExcecao {

	public static void main(String[] args) {
		ExemploThrow teste = new ExemploThrow();
		try{
			teste.lancandoExcecao();
		} catch (IOException e) {
			System.out.println("Mensagem de erro: "+ e.getMessage());
		}
	}

}
