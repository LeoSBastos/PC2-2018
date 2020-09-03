package br.com.prog2.trabalhofinal.persistencia;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.HospedagemServico;


public interface HospedagemServicoDAO {
	public String inserir(HospedagemServico hs);
	public String alterar(HospedagemServico hs);
	public String excluir(HospedagemServico hs);
	public List<HospedagemServico> listarTodos();
	public List<HospedagemServico> pesquisarPorCodHospedagem(Integer hos);
	public List<HospedagemServico> pesquisarPorCodServico(Integer se);
}

