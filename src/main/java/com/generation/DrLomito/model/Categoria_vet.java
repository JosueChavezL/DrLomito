package com.generation.DrLomito.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Categoria_vet {
//pojo
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categoria_id", unique=true, nullable=false)
	private Long categoria_id;
	private String categoria_nombre;
	
	
	public Categoria_vet(String categoria_nombre) {
		super();
		this.categoria_nombre = categoria_nombre;
	}// constructo
	
	
	public Categoria_vet() {}//constructor vacio


	public String getCategoria_nombre() {
		return categoria_nombre;
	}


	public void setCategoria_nombre(String categoria_nombre) {
		this.categoria_nombre = categoria_nombre;
	}


	public Long getCategoria_id() {
		return categoria_id;
	}
	
	
	
	
}//class
