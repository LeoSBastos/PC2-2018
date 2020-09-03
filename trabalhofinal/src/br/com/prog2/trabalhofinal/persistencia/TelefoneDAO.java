package br.com.prog2.trabalhofinal.persistencia;

import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Telefone;


public interface TelefoneDAO {
	public String inserir(Telefone te);
	public String excluir(Telefone te);
	public List<Telefone> listarTodos();
	public List<Telefone> pesquisarPorCodCliente(Integer codCliente);
}
