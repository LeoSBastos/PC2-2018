package br.com.prog2.trabalhofinal.controller;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.HospedagemServico;
import br.com.prog2.trabalhofinal.persistencia.HospedagemServicoDAOImp;

public class HospedagemServicoController {
	public String inserir(HospedagemServico hs) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.inserir(hs);
	}

	public String alterar(HospedagemServico hs) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.alterar(hs);
	}

	public String excluir(HospedagemServico hs) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.excluir(hs);
	}

	public List<HospedagemServico> listarTodos() {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.listarTodos();
	}

	public List<HospedagemServico> pesquisarPorCodHospedagem(Integer id) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.pesquisarPorCodHospedagem(id);
	}
	
	public List<HospedagemServico> pesquisarPorCodServico(Integer id) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.pesquisarPorCodServico(id);
	}
}
