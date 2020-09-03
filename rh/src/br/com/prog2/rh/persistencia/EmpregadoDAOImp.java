package br.com.prog2.rh.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.rh.negocio.Empregado;

public class EmpregadoDAOImp implements EmpregadoDAO {

	@Override
	public String inserir(Empregado emp) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into empregado(cpf, nome, idade,salario) values(?,?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, emp.getCpf());
			pst.setString(2, emp.getNome());
			pst.setInt(3, emp.getIdade());
			pst.setDouble(4, emp.getSalario());

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
	public String alterar(Empregado emp) {
		String sql = "update empregado set nome=?,idade=?,salario=? where cpf=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getNome());
			pst.setInt(2, emp.getIdade());
			pst.setDouble(3, emp.getSalario());
			pst.setString(4, emp.getCpf());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}

	@Override
	public String excluir(Empregado emp) {
		String sql = "delete from empregado where cpf=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getCpf());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluido com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}

	@Override
	public List<Empregado> listarTodos() {
		String sql = "select * from empregado";
		Connection con = ConnectionFactory.getConnection();
		List<Empregado> lst = new ArrayList<Empregado>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Empregado emp = new Empregado();
					emp.setCpf(rs.getString(1));
					emp.setNome(rs.getString(2));
					emp.setIdade(rs.getInt(3));
					emp.setSalario(rs.getDouble(4));
					lst.add(emp);
				}
				return lst;
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
	public Empregado pesquisarPorCpf(String cpf) {
		String sql = "select * from empregado where cpf=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Empregado emp = new Empregado();
				emp.setCpf(rs.getString(1));
				emp.setNome(rs.getString(2));
				emp.setIdade(rs.getInt(3));
				emp.setSalario(rs.getDouble(4));
				return emp;
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
