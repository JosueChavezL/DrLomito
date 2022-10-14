package com.generation.DrLomito.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.generation.DrLomito.model.Opiniones_vet;
import com.generation.DrLomito.service.opiniones_vetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="/api/opinionesVet/")
public class opiniones_vetController {
	
	private final opiniones_vetService opiniones_vetService;

	@Autowired
	public opiniones_vetController(com.generation.DrLomito.service.opiniones_vetService opiniones_vetService) {
		super();
		this.opiniones_vetService = opiniones_vetService;
	}//constructor controller
		
	@GetMapping
	public List<Opiniones_vet> getAllOpiniones_vet(){
		return  opiniones_vetService.getOpinionesVet();
	}//getAllOpinions
	
	@GetMapping (path="{opinionVetId}")
	public Opiniones_vet getOpiniones_vet(@PathVariable("opinionVetId") Long id){
		return  opiniones_vetService.getOpinion_vet(id);
	}//GetOpinionIndividua;
	
	@DeleteMapping (path="{opinionVetId}")
	public Opiniones_vet deleteOpiniones_vet(@PathVariable("opinionVetId") Long id){
		return  opiniones_vetService.deleteOpiniones_vet(id);
	}//Delete
	
	@PostMapping
	public Opiniones_vet addOpiniones_vet(@RequestBody Opiniones_vet Opiniones_vet) {
		return opiniones_vetService.addOpinion(Opiniones_vet);
	}//postOpinion
	
	@PutMapping (path="{opinionVetId}")
	public Opiniones_vet updateOpiniones_vet(@PathVariable("opinionVetId") Long id,
		@RequestParam(required = false) String opiniones_nombre_autor,
		@RequestParam(required = false) Integer opiniones_calificacion,
		@RequestParam(required = false) String opiniones_comentario,
		@RequestParam(required = false) Long usuarios_usuario_id){
			return opiniones_vetService.updateOpiniones(id, opiniones_nombre_autor, opiniones_calificacion,opiniones_comentario,usuarios_usuario_id);
	}//Opiniones 
	
}//classOpinionesVetController
