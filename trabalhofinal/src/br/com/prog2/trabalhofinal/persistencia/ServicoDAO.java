package br.com.prog2.trabalhofinal.persistencia;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Servico;

public interface ServicoDAO {
	public String inserir(Servico se);
	public String alterar(Servico se);
	public String excluir(Servico se);
	public List<Servico> listarTodos();
	public Servico pesquisarPorNomeServico(String nomeServico);
}
