package com.generation.DrLomito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.generation.DrLomito.model.TipoUsuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.DrLomito.service.TipoUsuarioService;

@RestController
@RequestMapping(path="/api/tiposusuario/")
public class TipoUsuarioController {

	private final TipoUsuarioService tipoUsuarioService;

	@Autowired
	public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
		super();
		this.tipoUsuarioService = tipoUsuarioService;
	}//constructor
	
	@GetMapping
	public List<TipoUsuario> getAllTiposUsuario(){
		return  tipoUsuarioService.getTiposUsuario();
	}//obtiene todos los tipos de usuario
	
	@GetMapping (path="{tipousuarioId}")
	public TipoUsuario getTipoUsuario(@PathVariable("tipousuarioId") Long id){
		return  tipoUsuarioService.getTipoUsuario(id);
	}//obtiene un solo tipo usuario
	
	@DeleteMapping (path="{tipousuarioId}")
	public TipoUsuario deleteTipoUsuario(@PathVariable("tipousuarioId") Long id){
		return  tipoUsuarioService.deleteTipoUsuario(id);
	}//borra un solo tipo usuario
	
	@PostMapping
	public TipoUsuario addTipoUsuario(@RequestBody TipoUsuario tipousuario) {
		return tipoUsuarioService.addTipoUsuario(tipousuario);
	}//add tipo de usuario
	
	@PutMapping(path="{tipousuarioId}")
	public TipoUsuario updateTipoUsuario(@PathVariable("tipousuarioId") Long id,
			@RequestParam (required = false) String tipo_usuario_nombre)
			 {
		return tipoUsuarioService.updateTipoUsuario(id, tipo_usuario_nombre);
	}//update tipo usuario
	
}
