package com.generation.DrLomito.controller;

import java.util.List;

import com.generation.DrLomito.model.Info_Veterinario;
import com.generation.DrLomito.service.Info_VeterinarioService;
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

@RestController
@RequestMapping(path="/api/info_veterinarios/")
public class Info_VeterinarioController {
	private final Info_VeterinarioService info_veterinarioService;

	
@Autowired
	public Info_VeterinarioController(Info_VeterinarioService info_veterinarioService) {
		super();
		this.info_veterinarioService = info_veterinarioService;
	}//constructor

@GetMapping
public List<Info_Veterinario> getAllInfo_Veterinario(){
	return info_veterinarioService.getInfo_Veterinarios();  //llama a getInfo_Veterinarios en el srevicio
}//get all


@GetMapping (path="{infovetId}")//http://localhost:8080/api/info_veterinarios/1 ??
	public Info_Veterinario getInfo_Veterinario(@PathVariable("infovetId") Long id){
		return info_veterinarioService.getInfo_Veterinario(id);
	}//getInfo_Veterinario
	
@DeleteMapping(path="{infovetId}") //http://localhost:8080/api/info_veterinarios/1
	public Info_Veterinario delete(@PathVariable("infovetId") Long id) {
		return info_veterinarioService.deleteInfo_Veterinario(id);
	}//deleteInfo_Veterinario
@PostMapping
	public Info_Veterinario addInfo_Veterinario(@RequestBody Info_Veterinario info_veterinario) {
		return info_veterinarioService.addInfo_Veterinario(info_veterinario);
}//addInfo_Veterinario
@PutMapping(path="{infovetId}")//http://localhost:8080/api/info_veterinario/1
	public Info_Veterinario updateInfo_Veterinario (@PathVariable("infovetId") Long id,
			@RequestParam (required = false) String veterinario_especialidad, 
			@RequestParam (required = false) Integer veterinario_calificacion,
			@RequestParam (required = false) String veterinario_descripcion,
			@RequestParam (required = false) String veterinario_servicios,
			@RequestParam (required = false) Double veterinario_costo_consulta) {
		return info_veterinarioService.updateInfo_Veterinario(id, veterinario_especialidad, veterinario_calificacion, veterinario_descripcion, veterinario_servicios, veterinario_costo_consulta);
	}//updateInfo_Veterinario
}//class Info_VeterinarioController







