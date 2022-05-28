package controller;


public class Diario{
		
	private int token;
	
	public void tokenAcesso(int id) {
		this.token = id;
	}
	
	public int retornaToken() {
		return token;
	}
	
}
