package com.generation.DrLomito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//pojo

@Entity
@Table(name="contacto_vet")
public class ContactoVet {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="contacto_id", unique=true, nullable=false)
	private Long contacto_id;
	private String veterinario_direccion;
	private String veterinario_telefono1;
	private String veterinario_telefono2;
	private Integer veterinario_horario_inicio;
	private Integer veterinario_horario_cierre;
	private Boolean veterinario_atencion_urgencias;
	private Long usuarios_usuario_id;
	
	
	public ContactoVet(Long contacto_id, String veterinario_direccion, String veterinario_telefono1,
			String veterinario_telefono2, Integer veterinario_horario_inicio, Integer veterinario_horario_cierre,
			Boolean veterinario_atencion_urgencias, Long usuarios_usuario_id) {
		super();
		this.contacto_id = contacto_id;
		this.veterinario_direccion = veterinario_direccion;
		this.veterinario_telefono1 = veterinario_telefono1;
		this.veterinario_telefono2 = veterinario_telefono2;
		this.veterinario_horario_inicio = veterinario_horario_inicio;
		this.veterinario_horario_cierre = veterinario_horario_cierre;
		this.veterinario_atencion_urgencias = veterinario_atencion_urgencias;
		this.usuarios_usuario_id = usuarios_usuario_id;
	}
	
	public ContactoVet() {}


	public String getVeterinario_direccion() {
		return veterinario_direccion;
	}



	public void setVeterinario_direccion(String veterinario_direccion) {
		this.veterinario_direccion = veterinario_direccion;
	}



	public String getVeterinario_telefono1() {
		return veterinario_telefono1;
	}



	public void setVeterinario_telefono1(String veterinario_telefono1) {
		this.veterinario_telefono1 = veterinario_telefono1;
	}



	public String getVeterinario_telefono2() {
		return veterinario_telefono2;
	}



	public void setVeterinario_telefono2(String veterinario_telefono2) {
		this.veterinario_telefono2 = veterinario_telefono2;
	}



	public Integer getVeterinario_horario_inicio() {
		return veterinario_horario_inicio;
	}



	public void setVeterinario_horario_inicio(Integer veterinario_horario_inicio) {
		this.veterinario_horario_inicio = veterinario_horario_inicio;
	}



	public Integer getVeterinario_horario_cierre() {
		return veterinario_horario_cierre;
	}



	public void setVeterinario_horario_cierre(Integer veterinario_horario_cierre) {
		this.veterinario_horario_cierre = veterinario_horario_cierre;
	}



	public Boolean getVeterinario_atencion_urgencias() {
		return veterinario_atencion_urgencias;
	}



	public void setVeterinario_atencion_urgencias(Boolean veterinario_atencion_urgencias) {
		this.veterinario_atencion_urgencias = veterinario_atencion_urgencias;
	}



	public Long getUsuarios_usuario_id() {
		return usuarios_usuario_id;
	}



	public void setUsuarios_usuario_id(Long usuarios_usuario_id) {
		this.usuarios_usuario_id = usuarios_usuario_id;
	}



	public Long getContacto_id() {
		return contacto_id;
	}



	@Override
	public String toString() {
		return "ContactoVet [contacto_id=" + contacto_id + ", veterinario_direccion=" + veterinario_direccion
				+ ", veterinario_telefono1=" + veterinario_telefono1 + ", veterinario_telefono2="
				+ veterinario_telefono2 + ", veterinario_horario_inicio=" + veterinario_horario_inicio
				+ ", veterinario_horario_cierre=" + veterinario_horario_cierre + ", veterinario_atencion_urgencias="
				+ veterinario_atencion_urgencias + ", usuarios_usuario_id=" + usuarios_usuario_id + "]";
	}

	
	

	
	
}