package br.com.prog2.trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhofinal.negocio.Telefone;



public class TelefoneDAOImp implements TelefoneDAO {
	@Override
	public String inserir(Telefone te) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into telefone (telefone,tipotelefone,codcliente) values (?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, te.getTelefone());
			pst.setInt(2, te.getTipoTelefone());
			pst.setDouble(3, te.getCodCliente());
			
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
	public String excluir(Telefone te) {
		String sql = "delete from telefone where telefone=? and codcliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, te.getTelefone());
			pst.setInt(2, te.getCodCliente());
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
	public List<Telefone> listarTodos(){
		String sql = "select * from telefone order by codcliente";
		Connection con = ConnectionFactory.getConnection();
		List<Telefone> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Telefone te = new Telefone();
					te.setCodCliente(rs.getInt(3));
					te.setTelefone(rs.getString(1));
					te.setTipoTelefone(rs.getInt(2));
					lista.add(te);
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
	public List<Telefone> pesquisarPorCodCliente(Integer codCliente) {
			String sql = "select * from telefone where codcliente=?";
			Connection con = ConnectionFactory.getConnection();
			List<Telefone> lista = new ArrayList<>();
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, codCliente);
				ResultSet rs = pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Telefone te = new Telefone ();
						te.setCodCliente(rs.getInt(3));
						te.setTelefone(rs.getString(1));
						te.setTipoTelefone(rs.getInt(2));
						lista.add(te);
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
