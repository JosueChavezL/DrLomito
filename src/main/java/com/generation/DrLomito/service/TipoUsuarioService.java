package com.generation.DrLomito.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.DrLomito.model.TipoUsuario;

@Service
public class TipoUsuarioService {
	
	private final TipoUsuarioRepository tipoUsuarioRepository;

	@Autowired
	public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
		super();
		this.tipoUsuarioRepository = tipoUsuarioRepository;
	}//constructor
	
	public List<TipoUsuario> getTiposUsuario(){
		return tipoUsuarioRepository.findAll();
	}//get all tipos de usuario
	
	public TipoUsuario getTipoUsuario(Long id) {
		return tipoUsuarioRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El tipo de usuario con el id" + id + " no existe.")
			);
	}//get single tipo usuario
	
	public TipoUsuario deleteTipoUsuario(Long id) {
		TipoUsuario tmpTipoUsuario = null;
		if(tipoUsuarioRepository.existsById(id)) {
			tmpTipoUsuario = tipoUsuarioRepository.findById(id).get();
			tipoUsuarioRepository.deleteById(id);
		}//if exists
		return tmpTipoUsuario;
	}//delete tipo usuario

	public TipoUsuario addTipoUsuario(TipoUsuario tipo_usuario_nombre) {
		return tipoUsuarioRepository.save(tipo_usuario_nombre);		
	}//agregar tipo de usuario
	
	public TipoUsuario updateTipoUsuario(Long id, String tipo_usuario_nombre) {
		TipoUsuario tmpTipoUsuario = null;
		if(tipoUsuarioRepository.existsById(id)) {
			tmpTipoUsuario = tipoUsuarioRepository.findById(id).get();
			if(tipo_usuario_nombre!=null) tmpTipoUsuario.setTipo_usuario_nombre(tipo_usuario_nombre);
			
			tipoUsuarioRepository.save(tmpTipoUsuario);
		}else{
			System.out.println("Update - El tipo de usuario con el id " + id + " no existe");
		}//if exists
		return tmpTipoUsuario;
	}//update tipo de usuario
	
}//class Tipo Usuario Service
