package model;

import java.sql.ResultSet;

public class UsuarioDAO {

	private Conexao conexao = new Conexao();
	private String sql = "";
	private int resultado = 0;
	private ResultSet consulta;
	
	public void insertSQL() {
		sql = ""
			
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void updateSQL() {
		sql = ""
				
			;
		resultado = conexao.executarComandosSQL(sql);
	}
	
	public void deleteSQL() {
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