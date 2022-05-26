package controller;

public class Diario {
	
	private int idToken;
	
	public void sessaoChecar() {
		System.out.println(idToken);
	}
	
	public int tokenAcesso(int id) {
		this.idToken = id;
		return id;
	}

}
