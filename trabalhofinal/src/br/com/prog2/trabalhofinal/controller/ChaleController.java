package br.com.prog2.trabalhofinal.controller;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Chale;
import br.com.prog2.trabalhofinal.persistencia.ChaleDAOImp;

public class ChaleController {
	public String inserir(Chale ch) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.inserir(ch);
	}

	public String alterar(Chale ch) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.alterar(ch);
	}

	public String excluir(Chale ch) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.excluir(ch);
	}

	public List<Chale> listarTodos() {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.listarTodos();
	}

	public Chale pesquisarPorcodChale(Integer codChale) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.pesquisarPorCodChale(codChale);
	}
	public Chale pesquisarCodChale(Chale cha) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.pesquisarCodChale(cha);
	}
}