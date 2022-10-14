package com.generation.DrLomito.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.DrLomito.model.ContactoVet;

@Service
public class ContactoVetService {
	private final ContactoVetRepository contactoVetRepository;
	
	@Autowired
	public ContactoVetService(ContactoVetRepository contactoVetRepository) {
		super();
		this.contactoVetRepository = contactoVetRepository;
	}
	
	public List<ContactoVet> getProductos(){
		return contactoVetRepository.findAll();
	}
	public ContactoVet getProductos(Long contacto_id){
		return contactoVetRepository.findById(contacto_id).orElseThrow(
				()->new IllegalArgumentException("El Producto con el id " + contacto_id + " no existe" )
				);
		}
	public ContactoVet deleteProducto (Long contacto_id) {
		ContactoVet tmpProd = null;
		if (contactoVetRepository.existsById(contacto_id)) {
			tmpProd = contactoVetRepository.findById(contacto_id).get();
			contactoVetRepository.deleteById(contacto_id);
		}//if exist
		return tmpProd;
		}//deleteProducto
	public ContactoVet addProducto(ContactoVet contactoVet) {
		return contactoVetRepository.save(contactoVet);
		}//addProducto
	public ContactoVet updateProducto(
			Long contacto_id, 
			String veterinario_direccion,
			String veterinario_telefono1,
			String veterinario_telefono2,
			Integer veterinario_horario_inicio,
			Integer veterinario_horario_cierre,			
			Boolean veterinario_atencion_urgencias,
			Long usuarios_usuario_id) {
		ContactoVet tmpProd = null;
		if (contactoVetRepository.existsById(contacto_id)) {
			tmpProd = contactoVetRepository.findById(contacto_id).get();
			if(veterinario_direccion!=null) tmpProd.setVeterinario_direccion(veterinario_direccion);
			if(veterinario_telefono1!=null) tmpProd.setVeterinario_telefono1(veterinario_telefono1);
			if(veterinario_telefono2!=null) tmpProd.setVeterinario_telefono2(veterinario_telefono2);
			if(veterinario_horario_inicio!=null) tmpProd.setVeterinario_horario_inicio(veterinario_horario_inicio.intValue());
			if(veterinario_horario_cierre!=null) tmpProd.setVeterinario_horario_cierre(veterinario_horario_cierre.intValue());
			if(veterinario_atencion_urgencias!=null) tmpProd.setVeterinario_atencion_urgencias(veterinario_atencion_urgencias.booleanValue());
			if(usuarios_usuario_id!=null) tmpProd.setUsuarios_usuario_id(usuarios_usuario_id);
			contactoVetRepository.save(tmpProd);
			
		}else {
			System.out.println("Update - El Veterinario con el id" + contacto_id + "no existe");
			
		} //if exist
		return tmpProd;
		
	}//updateProducto
	}//class ProductoService
