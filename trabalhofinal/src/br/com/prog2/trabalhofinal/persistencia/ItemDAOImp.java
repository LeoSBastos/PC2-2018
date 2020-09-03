package br.com.prog2.trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Item;


public class ItemDAOImp implements ItemDAO{
	@Override
	public String inserir(Item it) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into item (nomeitem,descricaoitem) values (?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, it.getNomeItem());
			pst.setString(2,it.getDescricaoItem());
			
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Deu merda";
			}

		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}
	@Override
	public String alterar(Item it) {
		String sql ="update item set descricaoitem=? where nomeitem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(2, it.getNomeItem());
			pst.setString(1, it.getDescricaoItem());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}

	@Override
	public String excluir(Item it) {
		String sql = "delete from item where nomeitem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, it.getNomeItem());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluido com sucesso";
			} else {
				return "Falha ao Excluir";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}
	@Override
	public List<Item> listarTodos(){
		String sql = "select * from item";
		Connection con = ConnectionFactory.getConnection();
		List<Item> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Item it = new Item();
					it.setNomeItem(rs.getString(1));
					it.setDescricaoItem(rs.getString(2));
					lista.add(it);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}
	@Override
	public Item pesquisarPorNomeItem(String nomeitem) {
		String sql = "select * from item where nomeitem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeitem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Item it = new Item ();
				it.setNomeItem(rs.getString(1));
				it.setDescricaoItem(rs.getString(2));
				return it;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}

		return null;
	}
}
