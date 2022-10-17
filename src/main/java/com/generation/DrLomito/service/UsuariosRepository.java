package com.generation.DrLomito.service;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.generation.DrLomito.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	@Query("SELECT u FROM Usuarios u WHERE u.usuario_correo=?1")
	Optional<Usuarios> findByUsername(String usuario_correo);// JPQL

}//interface UsuariosRepository
