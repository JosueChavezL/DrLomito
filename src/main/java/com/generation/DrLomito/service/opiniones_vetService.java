package com.generation.DrLomito.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.DrLomito.model.Opiniones_vet;

@Service
public class opiniones_vetService {
	private final opiniones_vetRepository opiniones_vetRepository;
	
	@Autowired
	public opiniones_vetService(com.generation.DrLomito.service.opiniones_vetRepository opiniones_vetRepository) {
		super();
		this.opiniones_vetRepository = opiniones_vetRepository;
	}

	public List<Opiniones_vet> getOpinionesVet() {
		return opiniones_vetRepository.findAll();
	}//getOpiniones
	
	public Opiniones_vet getOpinion_vet(Long id) {		
		return opiniones_vetRepository.findById(id).orElseThrow(()->new 
				IllegalArgumentException("Opinión" + id + " no existe."));
	}//getOpinionIndividual
	
	
	  public Opiniones_vet deleteOpiniones_vet(Long id) { 
		  Opiniones_vet tmpOpinion = null; 
		  if(opiniones_vetRepository.existsById(id)) { 
			  tmpOpinion = opiniones_vetRepository.findById(id).get();
			  opiniones_vetRepository.deleteById(id); 
			  }//ifExist return tmpOpinion;
		  return tmpOpinion;
	  }//deleteOpinion
	  
	  
	  public Opiniones_vet addOpinion(Opiniones_vet Opiniones_vet) {
		  return  opiniones_vetRepository.save(Opiniones_vet);
	  }//addOpinion
	  
	  public Opiniones_vet updateOpiniones(Long id, String opiniones_nombre_autor,
	  Integer opiniones_calificacion,String opiniones_comentario, Long usuarios_usuario_id) { 
		  Opiniones_vet tmpOpinion = null;
		  if(opiniones_vetRepository.existsById(id)) {
			  tmpOpinion =  opiniones_vetRepository.findById(id).get(); 
		  if(opiniones_nombre_autor!=null)tmpOpinion.setOpiniones_nombre_autor(opiniones_nombre_autor);
	      if(opiniones_calificacion!=null) tmpOpinion.setOpiniones_calificacion(opiniones_calificacion.intValue());
	      if(opiniones_comentario!=null) tmpOpinion.setOpiniones_comentario(opiniones_comentario);
	      if(usuarios_usuario_id!=null) tmpOpinion.setUsuarios_usuario_id(usuarios_usuario_id.longValue());
	      opiniones_vetRepository.save(tmpOpinion);
	  }else{
			System.out.println("Update - La opinion con el id " + id + " no existe");
		}//if exists
	  return tmpOpinion;	  
	  }//update Opinion
	  
	  
	 

}//class opiniones_vetService
