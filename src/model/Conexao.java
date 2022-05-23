package model;

import java.sql.*;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection conexao;
	
	Conexao(){
		url = "jdbc:postgresql://localhost:5432/diario";
		usuario = "postgres";
		senha = "2908";
		
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conexão realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executarComandosSQL(String sql) {
		try {
			Statement instrucao = conexao.createStatement();
			int resposta = instrucao.executeUpdate(sql);
			return resposta;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public ResultSet executarBucasSQL(String sql) {
		try {
			Statement instrucao = conexao.createStatement();
			ResultSet consulta = instrucao.executeQuery(sql);
			return consulta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
