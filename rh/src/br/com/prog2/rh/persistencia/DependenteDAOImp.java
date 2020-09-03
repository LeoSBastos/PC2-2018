package br.com.prog2.rh.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.rh.negocio.Dependente;

public class DependenteDAOImp implements DependenteDAO {

	@Override
	public String inserir(Dependente dep) {
		Connection con = ConnectionFactory.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into depedente(cpfEmpregado, nome,grauParentesco,dataNascimento) values (?,?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getCpfEmpregado());
			pst.setString(2, dep.getNome());
			pst.setString(3, dep.getGrauParentesco());
			pst.setObject(4, dep.getDataNascimento());
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
	public String alterar(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("update dependente set grauParentesco=?,dataNascimento=?	where nome=? and cpfEmpregado=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getGrauParentesco());
			pst.setObject(2, dep.getDataNascimento());
			pst.setString(3, dep.getNome());
			pst.setString(4, dep.getCpfEmpregado());
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
	public String excluir(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from dependente where nome=? and cpfEmpregado=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getNome());
			pst.setString(2, dep.getCpfEmpregado());
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
	public List<Dependente> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from dependente order by nome");
		Connection con = ConnectionFactory.getConnection();
		List<Dependente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Dependente dep = new Dependente();
					dep.setCpfEmpregado(rs.getString(1));
					dep.setNome(rs.getString(2));
					dep.setGrauParentesco(rs.getString(3));
					dep.setDataNascimento(rs.getObject(4, LocalDate.class));
					lista.add(dep);
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
	public List<Dependente> pesquisarPorEmpregado(String cpf) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from dependente where cpfempregado = ? order by nome");
		Connection con = ConnectionFactory.getConnection();
		List<Dependente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Dependente dep = new Dependente();
					dep.setCpfEmpregado(rs.getString(1));
					dep.setNome(rs.getString(2));
					dep.setGrauParentesco(rs.getString(3));
					dep.setDataNascimento(rs.getObject(4, LocalDate.class));
					lista.add(dep);
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
