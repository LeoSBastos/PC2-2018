package br.com.prog2.trabalhofinal.controller;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Servico;
import br.com.prog2.trabalhofinal.persistencia.ServicoDAOImp;

public class ServicoController {
	public String inserir(Servico se) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.inserir(se);
	}

	public String alterar(Servico se) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.alterar(se);
	}

	public String excluir(Servico se) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.excluir(se);
	}

	public List<Servico> listarTodos() {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.listarTodos();
	}

	public Servico pesquisarPorNomeServico(String nomeServico) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.pesquisarPorNomeServico(nomeServico);
	}

}