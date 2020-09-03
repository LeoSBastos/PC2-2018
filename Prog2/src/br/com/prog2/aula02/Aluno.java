package br.com.prog2.aula02;

public class Aluno {
	Integer matricula;
	String nome;
	Integer tempoDeEstudo;

	public void contabilizarTempoDeEstudo(int tempoEstudo) {
		int contarTempo = this.tempoDeEstudo + tempoEstudo;
		int tempoDeEstudo = contarTempo;
	}
}
