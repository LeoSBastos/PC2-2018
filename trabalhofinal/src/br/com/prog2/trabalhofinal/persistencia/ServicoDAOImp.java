package br.com.prog2.trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Servico;


public class ServicoDAOImp implements ServicoDAO{
	@Override
	public String inserir(Servico se) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into servico (nomeservico,valorservico) values (?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, se.getNomeServico());
			
			pst.setDouble(2,se.getValorServico());
			
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
	public String alterar(Servico se) {
		String sql ="update servico set nomeservico=?,valorservico=? where codservico=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, se.getNomeServico());
			pst.setDouble(2, se.getValorServico());
			pst.setInt(3, se.getCodServico());
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
	public String excluir(Servico se) {
		String sql = "delete from servico where codservico=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, se.getCodServico());
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
	public List<Servico> listarTodos(){
		String sql = "select * from servico order by codservico";
		Connection con = ConnectionFactory.getConnection();
		List<Servico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Servico se = new Servico();
					se.setCodServico(rs.getInt(1));
					se.setNomeServico(rs.getString(2));
					se.setValorServico(rs.getDouble(3));
					lista.add(se);
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
	public Servico pesquisarPorNomeServico(String nomeServico) {
		String sql = "select * from servico where nomeservico=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeServico);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Servico se = new Servico ();
				se.setCodServico(rs.getInt(1));
				se.setNomeServico(rs.getString(2));
				se.setValorServico(rs.getDouble(3));
				return se;
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
