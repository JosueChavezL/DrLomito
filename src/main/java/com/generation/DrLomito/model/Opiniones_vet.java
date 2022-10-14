package com.generation.DrLomito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Es una entidad
@Table(name="opiniones_vet")//Estableciendo nombre de base de datos
public class Opiniones_vet {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente
	@Column(name="opiniones_id",unique=true, nullable=false) // Not null
	private Long id;
	@Column(nullable=false)
	private String opiniones_nombre_autor;
	@Column(nullable=false)
	private Integer opiniones_calificacion;
	@Column(nullable=false)
	private String opiniones_comentario;
	@Column(nullable=false)
	private Long usuarios_usuario_id;
	public Opiniones_vet(Long id, String opiniones_nombre_autor, Integer opiniones_calificacion,
			String opiniones_comentario, Long usuarios_usuario_id) {
		super();
		this.id = id;
		this.opiniones_nombre_autor = opiniones_nombre_autor;
		this.opiniones_calificacion = opiniones_calificacion;
		this.opiniones_comentario = opiniones_comentario;
		this.usuarios_usuario_id = usuarios_usuario_id;
	}//constructor
	
	public Opiniones_vet() {} //Constructor vacio

	public String getOpiniones_nombre_autor() {
		return opiniones_nombre_autor;
	}

	public void setOpiniones_nombre_autor(String opiniones_nombre_autor) {
		this.opiniones_nombre_autor = opiniones_nombre_autor;
	}

	public Integer getOpiniones_calificacion() {
		return opiniones_calificacion;
	}

	public void setOpiniones_calificacion(Integer opiniones_calificacion) {
		this.opiniones_calificacion = opiniones_calificacion;
	}

	public String getOpiniones_comentario() {
		return opiniones_comentario;
	}

	public void setOpiniones_comentario(String opiniones_comentario) {
		this.opiniones_comentario = opiniones_comentario;
	}

	public Long getUsuarios_usuario_id() {
		return usuarios_usuario_id;
	}

	public void setUsuarios_usuario_id(Long usuarios_usuario_id) {
		this.usuarios_usuario_id = usuarios_usuario_id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Opiniones_vet [id=" + id + ", opiniones_nombre_autor=" + opiniones_nombre_autor
				+ ", opiniones_calificacion=" + opiniones_calificacion + ", opiniones_comentario="
				+ opiniones_comentario + ", usuarios_usuario_id=" + usuarios_usuario_id + "]";
	}
	
	
	
	
	
}//class OpinionesVet


