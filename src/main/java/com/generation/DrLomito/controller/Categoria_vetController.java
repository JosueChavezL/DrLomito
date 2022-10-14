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

import com.generation.DrLomito.service.Categoria_vetService;
import com.generation.DrLomito.model.Categoria_vet;


@RestController
@RequestMapping(path="/api/categoria_vet/") //http://localhost:8080/api/productos/2
public class Categoria_vetController {

	private final Categoria_vetService categoria_vetService;

	@Autowired
	public Categoria_vetController(Categoria_vetService categoria_vetService) {
		super();
		this.categoria_vetService = categoria_vetService;
	}//constructor
	
	@GetMapping
	public List<Categoria_vet> getAllCategories(){
		return categoria_vetService.getCategorias();  //llama a getcategorias en el srevicio
	}//get all
	
	@GetMapping(path="{categoria_id}")
	public Categoria_vet getCategoria(@PathVariable("categoria_id")Long id) { 
		return categoria_vetService.getCategoria(id);
	}// get one
	
	//@DeleteMapping
	
		@DeleteMapping (path="{categoria_id}")
		public Categoria_vet deleteCategoria(@PathVariable("categoria_id") Long id) {
			
			return  categoria_vetService.deleteCategoria(id);
		}//deleteProducto
		
		//@PostMapping
		@PostMapping
		public Categoria_vet addCategoria(@RequestBody Categoria_vet producto) {
			return categoria_vetService.addCategoria(producto);
		}
	
		//@PutMapping
		@PutMapping(path="{categoria_id}")
		public Categoria_vet updateCategoria(@PathVariable("categoria_id") Long id, 
			@RequestParam (required=false)String nombre)
			 {
			return categoria_vetService.updateCategoria(id, nombre);

		}
	
	
	
	
}//class
