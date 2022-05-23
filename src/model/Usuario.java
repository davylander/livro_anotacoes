package model;

public class Usuario {
	
	private int id;
	private String login;
	private String senha;
	private String nome;
	
	Usuario(){
		
	}
	
	Usuario(String login, String senha, String nome){
		this.setLogin(login);
		this.setSenha(senha);
		this.setNome(nome);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
