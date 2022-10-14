package com.generation.DrLomito.service;
import java.util.List;
import com.generation.DrLomito.model.Info_Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Info_VeterinarioService {
private final Info_VeterinarioRepository info_veterinarioRepository;

@Autowired
public Info_VeterinarioService(Info_VeterinarioRepository info_veterinarioRepository) {
	super();
	this.info_veterinarioRepository = info_veterinarioRepository;
}//constructor
public List<Info_Veterinario> getInfo_Veterinarios(){
	return info_veterinarioRepository.findAll();
}//get Info_Veterinarios

public Info_Veterinario getInfo_Veterinario(Long id){
	return info_veterinarioRepository.findById(id).orElseThrow(
			()->new IllegalArgumentException("Info_veterinario con el id" + id + "no existe.")
			);
}//get Info_Veterinario

public Info_Veterinario deleteInfo_Veterinario (Long id) {
	Info_Veterinario tmpInfovet = null;
	if (info_veterinarioRepository.existsById(id)){
			tmpInfovet = info_veterinarioRepository.findById(id).get();
			info_veterinarioRepository.deleteById(id);
	}//if exist
	return tmpInfovet;
}//deleteInfo_Veterinario
public Info_Veterinario addInfo_Veterinario(Info_Veterinario info_veterinario) {
	return info_veterinarioRepository.save(info_veterinario);
}//addinfo_veterinario
public Info_Veterinario updateInfo_Veterinario(Long id, String veterinario_especialidad,Integer veterinario_calificacion, String veterinario_descripcion, String veterinario_servicios, Double veterinario_costo_consulta) {
	Info_Veterinario tmpInfovet = null;
	if (info_veterinarioRepository.existsById(id)){
		tmpInfovet = info_veterinarioRepository.findById(id).get();
		if (veterinario_especialidad!=null) tmpInfovet.setVeterinario_especialidad(veterinario_especialidad);
		if (veterinario_calificacion!=null) tmpInfovet.setVeterinario_calificacion(veterinario_calificacion.intValue());
		if (veterinario_descripcion!=null) tmpInfovet.setVeterinario_descripcion(veterinario_descripcion);
		if (veterinario_servicios!=null) tmpInfovet.setVeterinario_servicios(veterinario_servicios);
		if (veterinario_costo_consulta!=null) tmpInfovet.setVeterinario_costo_consulta(veterinario_costo_consulta.doubleValue());
		info_veterinarioRepository.save(tmpInfovet);
		}else {
			System.out.println("Update - Info_Veterinario con el id " + id + "no existe.");
		}//if exist
	return tmpInfovet;
}//updateInfo_Veterinario
}//class Info_VeterinarioService







