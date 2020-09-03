package br.com.prog2.trabalhofinal.persistencia;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Chale;

public interface ChaleDAO {
	public String inserir(Chale ch);
	public String alterar(Chale ch);
	public String excluir(Chale ch);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodChale(Integer codChale);
	public Chale pesquisarCodChale(Chale cha);
}
