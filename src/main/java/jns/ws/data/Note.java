package jns.ws.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nota")
public class Note implements Serializable{
	private static final long serialVersionUID = 1L;

	public Note() {
	}
	
	public Note(String titulo, String contenido){
		setTitulo(titulo);
		setContenido(contenido);
	}

	@Id
	@Column(name="notaId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="notaTitulo")
	private String titulo;
	
	@Column(name="notaContenido")
	private String contenido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}	
}

