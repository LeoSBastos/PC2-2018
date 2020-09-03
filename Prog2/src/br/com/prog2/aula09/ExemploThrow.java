package br.com.prog2.aula09;

import java.io.IOException;

public class ExemploThrow {
	public void lancandoExcecao() throws IOException{
		throw new IOException("Lançando uma exceção");
	}
}
