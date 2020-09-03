package br.com.prog2.trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhofinal.negocio.ChaleItem;

public class ChaleItemDAOImp implements ChaleItemDAO {
	@Override
	public String inserir(ChaleItem ci) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into chaleitem (nomeitem,codchale) values (?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, ci.getNomeItem());
			pst.setInt(2, ci.getCodChale());

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
	public String excluir(ChaleItem ci) {
		String sql = "delete from chaleitem where nomeitem=? and codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ci.getNomeItem());
			pst.setInt(2, ci.getCodChale());
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
	public List<ChaleItem> listarTodos() {
		String sql = "select * from chaleitem order by codchale";
		Connection con = ConnectionFactory.getConnection();
		List<ChaleItem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ChaleItem ci = new ChaleItem();
					ci.setNomeItem(rs.getString(2));
					ci.setCodChale(rs.getInt(1));
					lista.add(ci);
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
	public List<ChaleItem> pesquisarPorNomeItem(String nomeitem) {
		String sql = "select * from chaleitem where nomeitem=? order by codchale";
		Connection con = ConnectionFactory.getConnection();
		List<ChaleItem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeitem);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ChaleItem ci = new ChaleItem();
					ci.setNomeItem(rs.getString(2));
					ci.setCodChale(rs.getInt(1));
					lista.add(ci);
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
	public List<ChaleItem> pesquisarPorcodChale(Integer codChale) {
		String sql = "select * from chaleitem where codchale=? order by nomeitem";
		Connection con = ConnectionFactory.getConnection();
		List<ChaleItem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codChale);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ChaleItem ci = new ChaleItem();
					ci.setNomeItem(rs.getString(2));
					ci.setCodChale(rs.getInt(1));
					lista.add(ci);
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

}
