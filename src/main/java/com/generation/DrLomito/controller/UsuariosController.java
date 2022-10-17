package com.generation.DrLomito.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.DrLomito.model.ChangePassword;
import com.generation.DrLomito.model.Usuarios;
import com.generation.DrLomito.service.UsuariosService;


@RestController
@RequestMapping("/api/usuarios/")
public class UsuariosController {
	
	private final UsuariosService usuariosService;

	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}//constructor
	
	

	@GetMapping
	public List<Usuarios> getAllUsuarios(){
		return usuariosService.getUsuarios();
	}//getAllUsuarios
	
	@GetMapping (path="{usId}")
	public Usuarios getUsuario(@PathVariable("usId") Long id){
		return usuariosService.getUsuario(id);
	}//getUsuario
	
	
	@DeleteMapping (path="{usId}")
	public Usuarios deleteUsuario(@PathVariable("usId") Long id){
		return usuariosService.deleteUsuarios(id);
	}//deleteUsuario
	
	
	@PostMapping
	public Usuarios addUsuario(@RequestBody Usuarios usuarios) {
		return usuariosService.addUsuario(usuarios);
	}//addUsuarios
	
	
	@PutMapping (path="{usId}")
	public Usuarios updateUsuarios(@PathVariable("usId") Long id,
		@RequestParam(required = false) String usuario_nombre,		
		@RequestParam(required = false) String veterinario_url_imagen,
		@RequestParam(required = false) Long tipo_usuario_id){
			return usuariosService.updateUsuarios(id, usuario_nombre, veterinario_url_imagen, tipo_usuario_id);
		
	}//updateUsuarios sin contrasena
	
	@PutMapping (path="psw/{usId}")
	public Usuarios updateUserPsw(@PathVariable("usId") Long id,				
		@RequestBody (required = false) ChangePassword changePassword)
	{
			return usuariosService.updateUserPsw(id, changePassword.getPassword(), changePassword.getNewPassword());
		
	}//actualizar solo el password
	
	
	
}//class UsuariosController
