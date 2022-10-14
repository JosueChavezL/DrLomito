package com.generation.DrLomito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {

	@Id //Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Que se genera automaticamente
	@Column(name="tipo_usuario_id", unique=true, nullable=false) //Unico y no nulo
	private Long tipo_usuario_id; //Read-only
	@Column(name="tipo_usuario_nombre", nullable=false)
	private String tipo_usuario_nombre;	
	
	//1.Constructor normal y vacio
	//2.Getter y Setter, del ID nomas Get
	//3.toString
	public TipoUsuario(Long tipo_usuario_id, String tipo_usuario_nombre) {
		super();
		this.tipo_usuario_id = tipo_usuario_id;
		this.tipo_usuario_nombre = tipo_usuario_nombre;
	}//constructor con campos
	
	public TipoUsuario () {} //Constructor vacio

	public String getTipoUsuarioNombre() {
		return tipo_usuario_nombre;
	}//getTipoUsuarioNombre

	public void setTipoUsuarioNombre(String tipo_usuario_nombre) {
		this.tipo_usuario_nombre = tipo_usuario_nombre;
	}//setTipoUsuarioNombre

	public Long getTipoUsuarioId() {
		return tipo_usuario_id;
	}//getTipoUsuarioId

	@Override
	public String toString() {
		return "TipoUsuario [tipo_usuario_id=" + tipo_usuario_id + ", tipo_usuario_nombre=" + tipo_usuario_nombre + "]";
	}//toString
		
	
}//class TipoUsuario
