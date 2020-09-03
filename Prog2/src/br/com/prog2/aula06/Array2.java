package br.com.prog2.aula06;

public class Array2 {

	public static void main(String[] args) {
		int[] numeros = new int[5];
		Integer[] numerosInteger = new Integer[3];
		String[] nomes = new String[4];
		Curso[] listaDeCursos = new Curso[6];

		for (int i = 0; i < listaDeCursos.length; i++) {
			Curso c = new Curso();
			c.cargaHoraria = i + 1;
			c.codigo = i + 1;
			c.descricao = "Aluno" + (i + 1);
			listaDeCursos[i] = c;
		}

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i + 1;
		}

		for (int i = 0; i < numerosInteger.length; i++) {
			numerosInteger[i] = i + 1;
		}

		for (int i = 0; i < nomes.length; i++) {
			nomes[i] = "Aluno" + (i + 1);
		}
		for (int i = 0; i < listaDeCursos.length; i++) {
			System.out.println(listaDeCursos[i].codigo);
			System.out.println(listaDeCursos[i].descricao);
			System.out.println(listaDeCursos[i].cargaHoraria);
		}

		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		for (int i = 0; i < numerosInteger.length; i++) {
			System.out.println(numerosInteger[i]);
		}
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}
		
		for (Curso c : listaDeCursos) {
			System.out.println(c.codigo);
			System.out.println(c.descricao);
			System.out.println(c.cargaHoraria);
		}
		for (String s : nomes) {
			System.out.println(s);
		}
		for (Integer ni : numerosInteger) {
			System.out.println(ni);
		}
		for (int n : numeros) {
			System.out.println(n);
		}

	}

}
