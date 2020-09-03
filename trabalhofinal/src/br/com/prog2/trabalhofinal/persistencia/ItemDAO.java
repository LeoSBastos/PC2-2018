package br.com.prog2.trabalhofinal.persistencia;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Item;


public interface ItemDAO {
	public String inserir(Item it);
	public String alterar(Item it);
	public String excluir(Item it);
	public List<Item> listarTodos();
	public Item pesquisarPorNomeItem(String nomeitem);
}
