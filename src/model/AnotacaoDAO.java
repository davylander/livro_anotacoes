package model;

import java.sql.*;
import java.time.LocalDate;

public class AnotacaoDAO {

	private Conexao conexao = new Conexao();
	private String sql = "";
	private int resultado = 0;
	private ResultSet consulta;
	
	public void inserirSQL(LocalDate data, String titulo, String texto, int usuarioId) {
		sql = "INSERT INTO anotacao (id, data, titulo, texto, usuario_id) " +
			  "VALUES (default, '"+data+"', '"+titulo+"', '"+texto+"', "+usuarioId+")"	
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void atualizarSQL(int id, String titulo, String texto) {
		sql = "UPDATE anotacao " +
			  "SET titulo = '"+titulo+"', texto = '"+texto+"' "	 +
			  "WHERE id = " + id
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void deletarSQL(int id) {
		sql = "DELETE FROM anotacao " +
			  "WHERE id = " + id
			
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void selecionarSQL() {
		sql = "SELECT * FROM anotacao"
				
			;
		consulta = conexao.executarBucasSQL(sql);
		
		try {
			while(consulta.next()) {
				int id = consulta.getInt("id");
				Date data = consulta.getDate("data");
				String titulo = consulta.getString("titulo");
				String texto = consulta.getString("texto");
				int usuarioId = consulta.getInt("usuario_id");
				//ideia de retornar varios arrays 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
