package controller;

import model.IdDeAcesso;

public class Diario{
	
	IdDeAcesso id = new IdDeAcesso();
	
	public void enviarToken(int token) {
		id.setTokenId(token);
	}
	
	public int retornaToken() {
		return id.getTokenId();
	}
	
	public boolean checarSalvamentoAnotacao(int idToken) {
		boolean resposta = false;
		if(idToken == id.getTokenId()) {
			resposta = true;
		}
		return resposta;
	}
	
}
