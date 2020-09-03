package br.com.prog2.trabalhofinal.persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhofinal.negocio.HospedagemServico;



public class HospedagemServicoDAOImp implements HospedagemServicoDAO {
	@Override
	public String inserir(HospedagemServico hs) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into hospedagemservico(codservico,valorservico,dataservico,codhospedagem) values (?,?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, hs.getCodServico());
			pst.setDouble(2, hs.getValorServico());
			pst.setObject(3, hs.getDataServico());
			pst.setInt(4, hs.getCodHospedagem());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao Inserir";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}

	@Override
	public String alterar(HospedagemServico hs) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("update hospedagemservico set valorservico=?,dataservico=? where codHospedagem=? and codservico=?");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(4, hs.getCodServico());
			pst.setDouble(1, hs.getValorServico());
			pst.setObject(2, hs.getDataServico());
			pst.setInt(3, hs.getCodHospedagem());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao Alterar";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}

	@Override
	public String excluir(HospedagemServico hs) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from hospedagemservico where codHospedagem=? and codservico=?");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, hs.getCodHospedagem());
			pst.setInt(2, hs.getCodServico());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao Excluir";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}

	@Override
	public List<HospedagemServico> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagemservico order by codhospedagem");
		Connection con = ConnectionFactory.getConnection();
		List<HospedagemServico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					HospedagemServico hs = new HospedagemServico();
					hs.setCodHospedagem(rs.getInt(4));
					hs.setCodServico(rs.getInt(3));
					hs.setValorServico(rs.getDouble(2));
					hs.setDataServico(rs.getObject(1, LocalDate.class));
					lista.add(hs);
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
	public List<HospedagemServico> pesquisarPorCodHospedagem(Integer hos) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagemservico where codHospedagem = ?");
		Connection con = ConnectionFactory.getConnection();
		List<HospedagemServico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, hos);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					HospedagemServico hs = new HospedagemServico();
					hs.setCodHospedagem(rs.getInt(4));
					hs.setCodServico(rs.getInt(3));
					hs.setValorServico(rs.getDouble(2));
					hs.setDataServico(rs.getObject(1, LocalDate.class));
					lista.add(hs);
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
	public List<HospedagemServico> pesquisarPorCodServico(Integer se) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagemservico where codServico = ?");
		Connection con = ConnectionFactory.getConnection();
		List<HospedagemServico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, se);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					HospedagemServico hs = new HospedagemServico();
					hs.setCodHospedagem(rs.getInt(4));
					hs.setCodServico(rs.getInt(3));
					hs.setValorServico(rs.getDouble(2));
					hs.setDataServico(rs.getObject(1, LocalDate.class));
					lista.add(hs);
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
