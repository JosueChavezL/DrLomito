package com.generation.DrLomito.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.DrLomito.jwt.config.JwtFilter;
import com.generation.DrLomito.model.Token;
import com.generation.DrLomito.model.Usuarios;
import com.generation.DrLomito.service.UsuariosService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {

	private final UsuariosService usuariosService;

	public LoginController(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}//constructor
	
	@PostMapping
	public Token login (@RequestBody Usuarios usuario) throws ServletException {
		if(usuariosService.validaUsuario(usuario)) {
			return new Token(generateToken(usuario.getUsuario_correo()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos.");
	}//login
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(username).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}// generateToken	
	
}//class Login Controller

