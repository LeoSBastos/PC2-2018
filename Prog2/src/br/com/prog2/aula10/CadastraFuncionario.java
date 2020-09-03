package br.com.prog2.aula10;

import java.util.*;

public class CadastraFuncionario {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		Funcionario f3 = new Funcionario();
		f1.setSalario(1500.56);
		f2.setSalario(1000.00);
		f3.setSalario(8000.89);
		f1.bonus(10);
		f2.bonus(12);
		f3.bonus(9);
		List funcionarios = new ArrayList();
		funcionarios.add(f1);
		funcionarios.add(f2);
		funcionarios.add(f3);
		System.out.println(funcionarios.size());
		for(int i = 0; i < funcionarios.size(); i++){
			Funcionario func = (Funcionario)funcionarios.get(i);
			System.out.println(func.getSalario());
		}
	
	
	}

}
