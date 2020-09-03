package br.com.prog2.aula04;

import br.com.prog2.util.DataPadraoBrasil;

public class Aluno {
    Integer matricula;
    String nome;
    DataPadraoBrasil dataDeNascimento;
	
    
    
    public Aluno(Integer matricula, String nome, DataPadraoBrasil dataDeNascimento) {
		this.matricula = matricula;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}
}
