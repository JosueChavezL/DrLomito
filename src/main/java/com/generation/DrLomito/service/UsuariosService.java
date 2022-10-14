package com.generation.DrLomito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.DrLomito.model.Usuarios;

@Service
public class UsuariosService {

	private final UsuariosRepository usuariosRepository;

	@Autowired
	public UsuariosService(UsuariosRepository usuariosRepository) {
		super();
		this.usuariosRepository = usuariosRepository;
	}//constructor usuariosRepository
	
	public List<Usuarios> getUsuarios(){
		return usuariosRepository.findAll();
	}//getUsuarios (trae todos)
	
	public Usuarios getUsuario(Long id){
		return usuariosRepository.findById(id).orElseThrow(()->new 
				IllegalArgumentException("El usuario con el id " + id + "no existe."));
	}//getUsuario (trae uno por id)
	
	public Usuarios deleteUsuarios(Long id) {
		Usuarios tmpUs = null;
		if(usuariosRepository.existsById(id)) {
			tmpUs = usuariosRepository.findById(id).get();
			usuariosRepository.deleteById(id);
		}//ifExist
			return tmpUs;
	}//deleteUsuario
	
	public Usuarios addUsuario(Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}//addUsuarios
	
	public Usuarios updateUsuarios(Long id, String usuario_nombre, String usuario_correo, 
			String usuario_contrasena, String veterinario_url_imagen, Long tipo_usuario_id) {
		Usuarios tmpUs = null;
		if(usuariosRepository.existsById(id)) {
			tmpUs = usuariosRepository.findById(id).get();
			if(usuario_nombre!=null) tmpUs.setUsuario_nombre(usuario_nombre);
			if(usuario_correo!=null) tmpUs.setUsuario_correo(usuario_correo);
			if(usuario_contrasena!=null) tmpUs.setUsuario_contrasena(usuario_contrasena);
			if(veterinario_url_imagen!=null) tmpUs.setVeterinario_url_imagen(veterinario_url_imagen);
			if(tipo_usuario_id!=null) tmpUs.setTipo_usuario_id(tipo_usuario_id.longValue());
			usuariosRepository.save(tmpUs);
		}else {
			System.out.println("Update - El Usuario con el id "
					           + id + "no existe. ");
		}//if / else exist
			return tmpUs;
		
	}//updateUsuario
	
	
	
}//class UsuariosService
