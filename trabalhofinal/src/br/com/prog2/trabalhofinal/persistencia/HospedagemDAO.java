package br.com.prog2.trabalhofinal.persistencia;


import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Hospedagem;

public interface HospedagemDAO {
	public String inserir(Hospedagem hos);
	public String alterar(Hospedagem hos);
	public String excluir(Hospedagem hos);
	public List<Hospedagem> listarTodos();
	public Hospedagem pesquisarPorCodHospedagem(Integer id);
	public Hospedagem pesquisarCodHospedagem(Hospedagem h);
	public List<Hospedagem> pesquisarPorCodCliente(Integer id);
	public List<Hospedagem> pesquisarPorCodChale(Integer id);
}
