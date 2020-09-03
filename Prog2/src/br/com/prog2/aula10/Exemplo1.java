package br.com.prog2.aula10;

import java.util.*;

public class Exemplo1 {

	public static void main(String[] args) {
		List lista = new ArrayList();
		lista.add("Ana");
		lista.add("Carla");
		lista.add("Maria");
		
		for (int i=0; i< lista.size();i++){
			System.out.println(lista.get(i));
		}
	}

}
