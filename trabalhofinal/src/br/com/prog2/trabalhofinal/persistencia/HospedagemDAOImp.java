package br.com.prog2.trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO {

	@Override
	public String inserir(Hospedagem hos) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into hospedagem(codChale,codCliente,estado,qtdPessoas,valorFinal,datainicio,datafim,desconto) values (?,?,?,?,?,?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, hos.getCodChale());
			pst.setInt(2, hos.getCodCliente());
			pst.setInt(3, hos.getEstado());
			pst.setInt(4, hos.getQtdPessoas());
			pst.setDouble(5, hos.getValorFinal());
			pst.setObject(6, hos.getDataInicio());
			pst.setObject(7, hos.getDataFim());
			pst.setDouble(8, hos.getDesconto());
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
	public String alterar(Hospedagem hos) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"update hospedagem set codChale=?,codCliente=?,estado=?,qtdPessoas=?,valorFinal=? where codHospedagem=?");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, hos.getCodChale());
			pst.setInt(2, hos.getCodCliente());
			pst.setInt(3, hos.getEstado());
			pst.setInt(4, hos.getQtdPessoas());
			pst.setDouble(5, hos.getValorFinal());
			pst.setInt(6, hos.getCodHospedagem());
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
	public String excluir(Hospedagem hos) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from hospedagem where codHospedagem=?");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, hos.getCodHospedagem());
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
	public List<Hospedagem> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagem order by codhospedagem");
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Hospedagem hos = new Hospedagem();
					hos.setCodHospedagem(rs.getInt(1));
					hos.setEstado(rs.getInt(2));
					hos.setDataInicio(rs.getObject(3, LocalDate.class));
					hos.setDataFim(rs.getObject(4, LocalDate.class));
					hos.setQtdPessoas(rs.getInt(5));
					hos.setDesconto(rs.getDouble(6));
					hos.setValorFinal(rs.getDouble(7));
					hos.setCodChale(rs.getInt(8));
					hos.setCodCliente(rs.getInt(9));
					lista.add(hos);
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
	public Hospedagem pesquisarPorCodHospedagem(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagem where codHospedagem = ?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Hospedagem hos = new Hospedagem();
				hos.setCodHospedagem(rs.getInt(1));
				hos.setEstado(rs.getInt(2));
				hos.setDataInicio(rs.getObject(3, LocalDate.class));
				hos.setDataFim(rs.getObject(4, LocalDate.class));
				hos.setQtdPessoas(rs.getInt(5));
				hos.setDesconto(rs.getDouble(6));
				hos.setValorFinal(rs.getDouble(7));
				hos.setCodChale(rs.getInt(8));
				hos.setCodCliente(rs.getInt(9));
				return hos;
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
	public List<Hospedagem> pesquisarPorCodCliente(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagem where codCliente=? order by codHospedagem");
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Hospedagem hos = new Hospedagem();
					hos.setCodHospedagem(rs.getInt(1));
					hos.setEstado(rs.getInt(2));
					hos.setDataInicio(rs.getObject(3, LocalDate.class));
					hos.setDataFim(rs.getObject(4, LocalDate.class));
					hos.setQtdPessoas(rs.getInt(5));
					hos.setDesconto(rs.getDouble(6));
					hos.setValorFinal(rs.getDouble(7));
					hos.setCodChale(rs.getInt(8));
					hos.setCodCliente(rs.getInt(9));
					lista.add(hos);
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
	public List<Hospedagem> pesquisarPorCodChale(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagem where codChale=? order by codHospedagem");
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Hospedagem hos = new Hospedagem();
					hos.setCodHospedagem(rs.getInt(1));
					hos.setEstado(rs.getInt(2));
					hos.setDataInicio(rs.getObject(3, LocalDate.class));
					hos.setDataFim(rs.getObject(4, LocalDate.class));
					hos.setQtdPessoas(rs.getInt(5));
					hos.setDesconto(rs.getDouble(6));
					hos.setValorFinal(rs.getDouble(7));
					hos.setCodChale(rs.getInt(8));
					hos.setCodCliente(rs.getInt(9));
					lista.add(hos);
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
	public Hospedagem pesquisarCodHospedagem(Hospedagem h) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagem where codChale=? and codCliente = ?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, h.getCodChale());
			pst.setInt(2, h.getCodCliente());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Hospedagem hos = new Hospedagem();
				hos.setCodHospedagem(rs.getInt(1));
				hos.setEstado(rs.getInt(2));
				hos.setDataInicio(rs.getObject(3, LocalDate.class));
				hos.setDataFim(rs.getObject(4, LocalDate.class));
				hos.setQtdPessoas(rs.getInt(5));
				hos.setDesconto(rs.getDouble(6));
				hos.setValorFinal(rs.getDouble(7));
				hos.setCodChale(rs.getInt(8));
				hos.setCodCliente(rs.getInt(9));
				return hos;
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
