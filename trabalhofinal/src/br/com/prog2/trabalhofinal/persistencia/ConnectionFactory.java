package br.com.prog2.trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection(){
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "postgres";
		String url = "jdbc:postgresql://127.0.0.1:5432/trabalhofinal";
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url,user,senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con) {
		try{
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
