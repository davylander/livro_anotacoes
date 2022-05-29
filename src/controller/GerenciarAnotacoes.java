package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.AnotacaoDAO;
import model.Anotacao;

public class GerenciarAnotacoes {

	AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
	Anotacao anotacao;
	
	public ArrayList<Anotacao> listarAnotacoes(int tokenId) {
		ArrayList<String> dados = anotacaoDAO.arraySelecionarSQL(tokenId);
		ArrayList<Anotacao> anotacoes = new ArrayList<Anotacao>();
		String[] arrayDados;
		for (int i = 0; i < dados.size(); i++) {
			arrayDados = dados.get(i).split(";");
			anotacoes.add(anotacao = new Anotacao(Integer.parseInt(arrayDados[0]),LocalDate.parse(arrayDados[1]),arrayDados[2],arrayDados[3],Integer.parseInt(arrayDados[4])));
		}
		return(anotacoes);
	}
	
	public void salvarAnotacao(String titulo, String texto, int usuarioId) {
		anotacaoDAO.inserirSQL(LocalDate.now(), titulo, texto, usuarioId);
	}
	
	public void deletarAnotacao(int idAnotacao) {
		anotacaoDAO.deletarSQL(idAnotacao);
	}
	
	public void editarAnotacao(int id, String titulo, String texto) {
		anotacaoDAO.atualizarSQL(id, titulo, texto);
	}
	
}
