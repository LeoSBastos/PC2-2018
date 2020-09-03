package br.com.prog2.trabalhofinal.controller;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Hospedagem;
import br.com.prog2.trabalhofinal.persistencia.HospedagemDAOImp;


public class HospedagemController {

	public String inserir(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.inserir(hos);
	}

	public String alterar(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(hos);
	}

	public String excluir(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.excluir(hos);
	}

	public List<Hospedagem> listarTodos() {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.listarTodos();
	}

	public Hospedagem pesquisarPorCodHospedagem(Integer id) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodHospedagem(id);
	}
	
	public List<Hospedagem> pesquisarPorCodCliente(Integer id) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodCliente(id);
	}

	public Hospedagem pesquisarCodHospedagem(Hospedagem h){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarCodHospedagem(h);
	}
	
	public List<Hospedagem> pesquisarPorCodChale(Integer id) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodChale(id);
	}

}
