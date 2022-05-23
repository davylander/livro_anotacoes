package model;

import java.sql.ResultSet;
import java.time.LocalDate;

public class AnotacaoDAO {

	private Conexao conexao = new Conexao();
	private String sql = "";
	private int resultado = 0;
	private ResultSet consulta;
	
	public void insertSQL(LocalDate data, String titulo, String texto, int usuarioId) {
		sql = "INSERT INTO anotacao (id, data, titulo, texto, usuario_id) " +
			  "VALUES (default, '"+data+"', '"+titulo+"', '"+texto+"', "+usuarioId+")"	
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void updateSQL(int id, String titulo, String texto) {
		sql = ""
			
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void deleteSQL(int id) {
		sql = ""
			
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void selectSQL() {
		sql = ""
				
			;
		consulta = conexao.executarBucasSQL(sql);
		
		try {
			while(consulta.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
