package controller;

import java.util.ArrayList;

import model.UsuarioDAO;
import model.Usuario;

public class GerenciarUsuarios {
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	Diario diario = new Diario();
	Usuario usuario;
	
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<String> dados = usuarioDAO.arraySelecionarSQL(); 
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String[] arrayDados;
		for(int i = 0; i < dados.size(); i ++) {
			arrayDados = dados.get(i).split(";");
			usuarios.add(usuario = new Usuario(Integer.parseInt(arrayDados[0]),arrayDados[1],arrayDados[2], arrayDados[3]));
		}
		return(usuarios);
	}
	
	public int validarCadastro(String login) {
		if(listarUsuarios().size() > 0) {
			for(int i = 0; i < listarUsuarios().size(); i++) {
				if(listarUsuarios().get(i).getLogin().equals(login)) {
					return 2;
				}else {
					return 1;
				}
			}
		}else {
			return 1;
		}
		return 0;
	}
	
	public void cadastrar(String login, String senha, String nome) {
		usuarioDAO.inserirSQL(login, senha, nome);
	}
	
	public boolean acessar(String login, String senha) {
		boolean retorno = false;
		for(int i = 0; i < listarUsuarios().size(); i ++) {
			if(listarUsuarios().get(i).getLogin().equals(login) && listarUsuarios().get(i).getSenha().equals(senha)) {
				retorno = true;
				diario.tokenAcesso(listarUsuarios().get(i).getId());
			}
		}
		return retorno;
	}
	
	public int tokenAcesso(String login, String senha) {
		int retorno = 0;
		for(int i = 0; i < listarUsuarios().size(); i ++) {
			if(listarUsuarios().get(i).getLogin().equals(login) && listarUsuarios().get(i).getSenha().equals(senha)) {
				retorno = listarUsuarios().get(i).getId();
			}
		}
		return retorno;
	}
	
	
}
