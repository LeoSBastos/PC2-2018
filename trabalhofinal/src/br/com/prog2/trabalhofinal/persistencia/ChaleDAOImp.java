package br.com.prog2.trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Chale;


public class ChaleDAOImp implements ChaleDAO{
	@Override	
	public String inserir(Chale ch) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Chale (localizacao,valoraltaestacao,valorbaixaestacao,capacidade) values (?,?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, ch.getLocalizacao());
			pst.setDouble(2, ch.getValorAltaEstacao());
			pst.setDouble(3, ch.getValorBaixaEstacao());
			pst.setInt(4, ch.getCapacidade());
			
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
	public String alterar(Chale ch) {
		String sql ="update chale set localizacao=?,valorbaixaestacao=?,valoraltaestacao=?,capacidade=? where codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(5, ch.getCodChale());
			pst.setString(1, ch.getLocalizacao());
			pst.setDouble(3, ch.getValorAltaEstacao());
			pst.setDouble(2, ch.getValorBaixaEstacao());
			pst.setInt(4, ch.getCapacidade());
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
	public String excluir(Chale ch) {
		String sql = "delete from Chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, ch.getCodChale());
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
	public List<Chale> listarTodos(){
		String sql = "select * from Chale order by codChale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Chale ch = new Chale();
					ch.setCodChale(rs.getInt(1));
					ch.setLocalizacao(rs.getString(2));
					ch.setValorAltaEstacao(rs.getDouble(3));
					ch.setValorBaixaEstacao(rs.getDouble(4));
					ch.setCapacidade(rs.getInt(5));
					lista.add(ch);
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
	public Chale pesquisarPorCodChale(Integer codChale) {
		String sql = "select * from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codChale);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale ch = new Chale();
				ch.setCodChale(rs.getInt(1));
				ch.setLocalizacao(rs.getString(2));
				ch.setValorAltaEstacao(rs.getDouble(3));
				ch.setValorBaixaEstacao(rs.getDouble(4));
				ch.setCapacidade(rs.getInt(5));
				return ch;
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
	public Chale pesquisarCodChale(Chale cha) {
		String sql = "select * from chale where localizacao=? and capacidade=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cha.getLocalizacao());
			pst.setInt(2, cha.getCapacidade());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale ch = new Chale();
				ch.setCodChale(rs.getInt(1));
				ch.setLocalizacao(rs.getString(2));
				ch.setValorAltaEstacao(rs.getDouble(3));
				ch.setValorBaixaEstacao(rs.getDouble(4));
				ch.setCapacidade(rs.getInt(5));
				return ch;
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
