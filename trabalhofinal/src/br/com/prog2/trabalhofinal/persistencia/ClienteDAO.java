package br.com.prog2.trabalhofinal.persistencia;
import java.util.List;
import br.com.prog2.trabalhofinal.negocio.Cliente;

public interface ClienteDAO {
	public String inserir(Cliente cli);
	public String alterar(Cliente cli);
	public String excluir(Cliente cli);
	public List<Cliente> listarTodos();
	public Cliente pesquisarPorCodigo(Integer codigo);
}