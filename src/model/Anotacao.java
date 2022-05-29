package model;

import java.time.LocalDate;

public class Anotacao {

	private int id;
	private LocalDate data;
	private String titulo;
	private String texto;
	private int usuarioId;
	
	public Anotacao(){
		
	}
	
	public Anotacao(int id, LocalDate data,String titulo, String texto, int usuarioId){
		this.setId(id);
		this.setData(LocalDate.now());
		this.setTitulo(titulo);
		this.setTexto(texto);
		this.setUsuarioId(usuarioId);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
}
