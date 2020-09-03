package br.com.prog2.trabalhofinal.controller;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Telefone;
import br.com.prog2.trabalhofinal.persistencia.TelefoneDAOImp;



public class TelefoneController {
	public String inserir(Telefone te) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.inserir(te);
	}

	public String excluir(Telefone te) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.excluir(te);
	}

	public List<Telefone> listarTodos() {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.listarTodos();
	}

	public List<Telefone> pesquisarPorCodCliente(Integer codCliente) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.pesquisarPorCodCliente(codCliente);
	}

}