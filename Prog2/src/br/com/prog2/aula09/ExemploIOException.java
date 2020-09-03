package br.com.prog2.aula09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploIOException {

	public static void main(String[] args) {
		try{
		BufferedReader in = new BufferedReader(new FileReader("teste.txt"));
		String str;
		while(((str = in.readLine()) != null)){
			System.out.println(str);
		}
		in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problemas com o arquivo: " + e.getMessage());
		}
	}

}
