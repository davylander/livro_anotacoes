package controller;

public class Diario {
	
	private int idToken;
	
	public void tokenAcesso(int id) {
		this.idToken = id;
	}
	
	public int retornaToken() {
		return idToken;
	}
	
	
	
}
