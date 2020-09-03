package br.com.prog2.heranca1;

public class Animal {
	String nome;
	String raca;
	
	public Animal(){
		
	}
	public Animal(String nome){
		this.nome=nome;
	}
	public String caminha(){
		return "Animal Caminhando";
	}
}
