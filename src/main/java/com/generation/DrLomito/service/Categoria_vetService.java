package com.generation.DrLomito.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.DrLomito.service.Categoria_vetRepository;
import com.generation.DrLomito.model.Categoria_vet;
@Service
public class Categoria_vetService {
	
	private final Categoria_vetRepository categoria_vetRepository;
	
	
	@Autowired
	public Categoria_vetService(Categoria_vetRepository categoria_vetRepository) {
		super();
		this.categoria_vetRepository = categoria_vetRepository;
	}//constructor
	
	public List<Categoria_vet> getCategorias(){
		return categoria_vetRepository.findAll();
		
	}
	
	public Categoria_vet getCategoria(Long id) {
		return categoria_vetRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("La categoria con el id "+id+" no existe"));
	}
	
	public Categoria_vet deleteCategoria(Long id) {
		Categoria_vet tmpProd=null;
		if (categoria_vetRepository.existsById(id)) {
			tmpProd=categoria_vetRepository.findById(id).get();
			
			categoria_vetRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//delete
	
	public Categoria_vet addCategoria(Categoria_vet categoria_vet) {
		return categoria_vetRepository.save(categoria_vet);
	}//add catecoria
	
	
	public Categoria_vet updateCategoria(Long id, String nombre) {
		Categoria_vet tmpProd=null;
		if (categoria_vetRepository.existsById(id)) {
			tmpProd=categoria_vetRepository.findById(id).get();
			if (nombre!=null) tmpProd.setCategoria_nombre(nombre);					
			categoria_vetRepository.save(tmpProd);
		}else{
			System.out.println("update -la categoria con id "+id+" no existe.");			
		}//if exist		
		return tmpProd;
	}//update
	
	
}//class
