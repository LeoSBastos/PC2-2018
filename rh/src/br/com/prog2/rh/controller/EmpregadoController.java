package br.com.prog2.rh.controller;

import java.util.List;

import br.com.prog2.rh.negocio.Empregado;
import br.com.prog2.rh.persistencia.EmpregadoDAOImp;

public class EmpregadoController{
	
	public String inserir(Empregado emp) {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.inserir(emp);
	}

	public String alterar(Empregado emp) {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.alterar(emp);
	}

	public String excluir(Empregado emp) {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.excluir(emp);
	}

	public List<Empregado> listarTodos() {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.listarTodos();
	}

	public Empregado pesquisarPorCpf(String cpf) {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.pesquisarPorCpf(cpf);
	}
	
}
