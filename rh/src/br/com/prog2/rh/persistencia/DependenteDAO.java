package br.com.prog2.rh.persistencia;

import java.util.List;

import br.com.prog2.rh.negocio.Dependente;

public interface DependenteDAO {
	public String inserir(Dependente dep);
	public String alterar(Dependente dep);
	public String excluir(Dependente dep);
	public List<Dependente> listarTodos();
	public List<Dependente> pesquisarPorEmpregado(String cpf);
}
