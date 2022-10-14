package com.generation.DrLomito.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//POJO
@Entity//Es una entidad
@Table(name="info_veterinario")//Estableciendo el nombre de la tabla en la base de datos
public class Info_Veterinario {
	@Id //id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Genera automáticamente
	@Column(name="info_veterinario_id", unique=true, nullable=false)//único y no es nulo
	private Long info_veterinario_id;
	private Long categoria_vet_categoria_id;
	private Long usuarios_usuario_id;
	@Column(nullable=false)
	private String veterinario_especialidad;
	@Column(nullable=false)
	private Integer veterinario_calificacion;
	@Column(nullable=false)
	private String veterinario_descripcion;
	@Column(nullable=false)
	private String veterinario_servicios;
	@Column(nullable=false)
	private Double veterinario_costo_consulta;
	
	
	
	
	
	public Info_Veterinario( Long categoria_vet_categoria_id, Long usuarios_usuario_id,
			String veterinario_especialidad, Integer veterinario_calificacion, String veterinario_descripcion,
			String veterinario_servicios, Double veterinario_costo_consulta) {
		super();
		this.categoria_vet_categoria_id = categoria_vet_categoria_id;
		this.usuarios_usuario_id = usuarios_usuario_id;
		this.veterinario_especialidad = veterinario_especialidad;
		this.veterinario_calificacion = veterinario_calificacion;
		this.veterinario_descripcion = veterinario_descripcion;
		this.veterinario_servicios = veterinario_servicios;
		this.veterinario_costo_consulta = veterinario_costo_consulta;
	}//constructor



	public Info_Veterinario() {}//constructor

	public String getVeterinario_especialidad() {
		return veterinario_especialidad;
	}//getVeterinario_especialidad

	public void setVeterinario_especialidad(String veterinario_especialidad) {
		this.veterinario_especialidad = veterinario_especialidad;
	}//setVeterinario_especialidad

	public Integer getVeterinario_calificacion() {
		return veterinario_calificacion;
	}//getVeterinario_calificacion

	public void setVeterinario_calificacion(Integer veterinario_calificacion) {
		this.veterinario_calificacion = veterinario_calificacion;
	}//setVeterinario_calificacion

	public String getVeterinario_descripcion() {
		return veterinario_descripcion;
	}//getVeterinario_descripcion

	public void setVeterinario_descripcion(String veterinario_descripcion) {
		this.veterinario_descripcion = veterinario_descripcion;
	}//setVeterinario_descripcion

	public String getVeterinario_servicios() {
		return veterinario_servicios;
	}//getVeterinario_servicios

	public void setVeterinario_servicios(String veterinario_servicios) {
		this.veterinario_servicios = veterinario_servicios;
	}//setVeterinario_servicios

	public Double getVeterinario_costo_consulta() {
		return veterinario_costo_consulta;
	}//getVeterinario_costo_consulta

	public void setVeterinario_costo_consulta(Double veterinario_costo_consulta) {
		this.veterinario_costo_consulta = veterinario_costo_consulta;
	}//setVeterinario_costo_consulta

	public Long getInfo_veterinario_id() {
		return info_veterinario_id;
	}//getInfo_veterinario_id

	public Long getCategoria_vet_categoria_id() {
		return categoria_vet_categoria_id;
	}//getCategoria_vet_categoria_id

	public Long getUsuarios_usuario_id() {
		return usuarios_usuario_id;
	}//getUsuarios_usuario_id

	@Override
	public String toString() {
		return "Info_Veterinario [info_veterinario_id=" + info_veterinario_id + ", categoria_vet_categoria_id="
				+ categoria_vet_categoria_id + ", usuarios_usuario_id=" + usuarios_usuario_id
				+ ", veterinario_especialidad=" + veterinario_especialidad + ", veterinario_calificacion="
				+ veterinario_calificacion + ", veterinario_descripcion=" + veterinario_descripcion
				+ ", veterinario_servicios=" + veterinario_servicios + ", veterinario_costo_consulta="
				+ veterinario_costo_consulta + "]";
	}//toString
	
}//class Info_Veterinario









