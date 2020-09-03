package br.com.prog2.heranca1;

public class Administrativo extends Assistente {
	String turno;
	Double adinoturno;
	
	public Administrativo(String nome, String matricula, String turno) {
		super(nome, matricula);
		this.turno = turno;
	}
	
}
