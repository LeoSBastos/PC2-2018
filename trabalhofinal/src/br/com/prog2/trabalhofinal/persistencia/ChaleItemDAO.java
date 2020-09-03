package br.com.prog2.trabalhofinal.persistencia;


import java.util.List;

import br.com.prog2.trabalhofinal.negocio.ChaleItem;

public interface ChaleItemDAO {
	public String inserir(ChaleItem ci);
	public String excluir(ChaleItem ci);
	public List<ChaleItem> listarTodos();
	public List<ChaleItem> pesquisarPorNomeItem(String nomeitem);
	public List<ChaleItem> pesquisarPorcodChale(Integer codChale);
}
