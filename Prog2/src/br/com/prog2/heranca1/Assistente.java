package br.com.prog2.heranca1;

public class Assistente extends Funcionario{
	protected String matricula;
	
	public Assistente(String nome, String matricula) {
		super(nome);
		this.matricula=matricula;
	}
	
	public String getMatricula() {
		return matricula;
	}
	@Override
	public String exibeDados() {
		return super.exibeDados()+"\nMatricula: "+getMatricula();
	}
}
