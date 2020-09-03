package br.com.prog2.heranca1;

public class Tecnico extends Assistente {
	Double bonussalario;
		
	public Tecnico(String nome, String matricula) {
		super(nome,matricula);
	}
	
	public void setBonussalario(Double bonussalario) {
		this.bonussalario = bonussalario;
	}
	
}
