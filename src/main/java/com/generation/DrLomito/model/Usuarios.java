package com.generation.DrLomito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usuario_id", unique= true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String usuario_nombre;
	@Column(nullable = false)
	private String usuario_correo;
	@Column(nullable = false)
	private String usuario_contrasena;
	@Column (name="veterinario_urlimagen")
	private String veterinario_url_imagen;
	@Column(name="tipo_usuario_tipo_usuario_id", nullable = false)
	private Long tipo_usuario_id;
	
	
	public Usuarios(Long id, String usuario_nombre, String usuario_correo, String usuario_contrasena,
			String veterinario_url_imagen, Long tipo_usuario_id) {
		super();
		this.id = id;
		this.usuario_nombre = usuario_nombre;
		this.usuario_correo = usuario_correo;
		this.usuario_contrasena = usuario_contrasena;
		this.veterinario_url_imagen = veterinario_url_imagen;
		this.tipo_usuario_id = tipo_usuario_id;
	}//constructor
	
	public Usuarios () {}//constructor vacío

	public String getUsuario_nombre() {
		return usuario_nombre;
	}//getNombre

	public void setUsuario_nombre(String usuario_nombre) {
		this.usuario_nombre = usuario_nombre;
	}//setNombre

	public String getUsuario_correo() {
		return usuario_correo;
	}//getCorreo

	public void setUsuario_correo(String usuario_correo) {
		this.usuario_correo = usuario_correo;
	}//setCorreo

	public String getUsuario_contrasena() {
		return usuario_contrasena;
	}//getContraseña

	public void setUsuario_contrasena(String usuario_contrasena) {
		this.usuario_contrasena = usuario_contrasena;
	}//setContraseña

	public String getVeterinario_url_imagen() {
		return veterinario_url_imagen;
	}//getURL

	public void setVeterinario_url_imagen(String veterinario_url_imagen) {
		this.veterinario_url_imagen = veterinario_url_imagen;
	}//setURL

	public Long getId() {
		return id;
	}//getId

	public Long getTipo_usuario_id() {
		return tipo_usuario_id;
	}//getIdTipoDeUsuario
	
	public void setTipo_usuario_id(Long tipo_usuario_id) {
		this.tipo_usuario_id = tipo_usuario_id;
	}//setTipo

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", ususario_nombre=" + usuario_nombre + ", usuario_correo=" + usuario_correo
				+ ", usuario_contrasena=" + usuario_contrasena + ", veterinario_url_imagen=" + veterinario_url_imagen
				+ ", tipo_usuario_id=" + tipo_usuario_id + "]";
	}//toString
	
	
	
	
	
	
	
}//class Usuarios
