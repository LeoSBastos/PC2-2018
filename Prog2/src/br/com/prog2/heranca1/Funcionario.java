package br.com.prog2.heranca1;

public class Funcionario {
	private String nome;
	
	public Funcionario(String nome){
		this.nome=nome;
	}
	
	public String exibeDados(){
		return "Nome: "+this.nome;
	}
}
