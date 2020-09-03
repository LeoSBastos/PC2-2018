package br.com.prog2.trabalhofinal.controller;


import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Item;
import br.com.prog2.trabalhofinal.persistencia.ItemDAOImp;

public class ItemController {
	public String inserir(Item it) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.inserir(it);
	}

	public String alterar(Item it) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.alterar(it);
	}

	public String excluir(Item it) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.excluir(it);
	}

	public List<Item> listarTodos() {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.listarTodos();
	}

	public Item pesquisarPorNomeItem(String nomeitem) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.pesquisarPorNomeItem(nomeitem);
	}

}
