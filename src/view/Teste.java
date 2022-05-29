package view;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.GerenciarUsuarios;
import controller.GerenciarAnotacoes;
import controller.Diario;

public class Teste {

	public static void main(String[] args) {
		GerenciarAnotacoes anotacoes = new GerenciarAnotacoes();
		for(int i = 0; i < anotacoes.listarAnotacoes(1).size(); i ++) {
			System.out.println(anotacoes.listarAnotacoes(1).get(i).getTexto());
		}
		
	}

}
