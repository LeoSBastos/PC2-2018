package br.com.prog2.trabalhofinal.controller;



import java.util.List;

import br.com.prog2.trabalhofinal.negocio.ChaleItem;
import br.com.prog2.trabalhofinal.persistencia.ChaleItemDAOImp;

public class ChaleItemController {
	public String inserir(ChaleItem ci) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.inserir(ci);
	}

	public String excluir(ChaleItem ci) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.excluir(ci);
	}

	public List<ChaleItem> listarTodos() {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.listarTodos();
	}

	public List<ChaleItem> pesquisarPorNomeItem(String nomeitem) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.pesquisarPorNomeItem(nomeitem);
	}
	public List<ChaleItem> pesquisarPorcodChale(Integer codchale) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.pesquisarPorcodChale(codchale);
	}

}
