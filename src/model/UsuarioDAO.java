package model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {

	private Conexao conexao = new Conexao();
	private String sql = "";
	private int resultado = 0;
	private ResultSet consulta;
	
	public void inserirSQL(String login, String senha, String nome) {
		sql = "INSERT INTO usuario (id, login, senha, nome) " +
			  "VALUES (default, '"+login+"', '"+senha+"', '"+nome+"')"
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void atualizarSQL(int id, String login, String senha, String nome) {
		sql = "UPDATE usuario " +
			  "SET login = '"+login+"', senha = '"+senha+"', nome = '"+nome+"' " +
			  "WHERE id = " + id
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void deletarSQL(int id) {
		sql = "DELETE FROM usuario " +
			  "WHERE id = " + id	
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void selecionarSQL() {
		sql = "SELECT * FROM usuario"
				
			;
		consulta = conexao.executarBucasSQL(sql);
		
		try {
			while(consulta.next()) {
				int id = consulta.getInt("id");
				String login = consulta.getString("login"); 
				String senha = consulta.getString("senha");
				String nome = consulta.getString("nome");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList arraySelecionarSQL() {
		sql = "SELECT * FROM usuario"
				
			;
		consulta = conexao.executarBucasSQL(sql);
		ArrayList<String> select = new ArrayList<>(); 
		
		try {
			while(consulta.next()) {
				int id = consulta.getInt("id");
				String idString = Integer.toString(id);
				String login = consulta.getString("login"); 
				String senha = consulta.getString("senha");
				String nome = consulta.getString("nome");
				
				select.add(idString+";"+login+";"+senha+";"+nome);
			}
			return(select);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
}
