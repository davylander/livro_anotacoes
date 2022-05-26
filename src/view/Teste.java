package view;

import java.util.ArrayList;

import controller.GerenciarUsuarios;
import controller.Diario;

public class Teste {

	public static void main(String[] args) {
		GerenciarUsuarios gerenciarUsuarios = new GerenciarUsuarios();
		Diario diario = new Diario();

		System.out.println(gerenciarUsuarios.acessar("Heisenstark", "saulo123"));
		diario.sessaoChecar();
		
	}

}
