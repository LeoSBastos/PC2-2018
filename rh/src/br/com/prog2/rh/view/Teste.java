package br.com.prog2.rh.view;


import br.com.prog2.rh.controller.EmpregadoController;
import br.com.prog2.rh.negocio.Empregado;

public class Teste {
	public static void main(String[] args) {
		/*Connection con = ConnectionFactory.getConnection();
		if(con != null){
			System.out.println("Connected");
		}*/
		Empregado e = new Empregado();
		
		e.setCpf("12345678913");
		e.setNome("Trap");
		e.setIdade(21);
		e.setSalario(10.0);
		EmpregadoController ec = new EmpregadoController();
		System.out.println(ec.inserir(e));
	}
}
