package com.generation.DrLomito.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {
	public static String secret = "Booleanos-creativos-lomitos-competitivos#20221017";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader =  httpServletRequest.getHeader("authorization");
		if (  (("POST".equals(httpServletRequest.getMethod()))&&
				(! httpServletRequest.getRequestURI().contains("/api/usuarios/") ) &&
				(! httpServletRequest.getRequestURI().contains("/api/info_veterinarios/") ) &&
				(! httpServletRequest.getRequestURI().contains("/api/contactoVet/") )
				) ||
		/* esta parte del get se elimina por que en nuestra aplicacion, no es necesario estar iniciado para ver nada.
		 * ( ("GET".equals(httpServletRequest.getMethod())) && (!
		 * httpServletRequest.getRequestURI().contains("/api/usuarios/") ) ) ||
		 */
			  ("PUT".equals(httpServletRequest.getMethod())) ||
			  ("DELETE".equals(httpServletRequest.getMethod()))
			) {
				if  ( authHeader ==null || !authHeader.startsWith("Bearer: ") ) {
					throw new ServletException("1. Invalid Token");
				}// if authHedaer
				String token = authHeader.substring(7);
				try {
				Claims claims = Jwts.parser().setSigningKey(secret)
						.parseClaimsJws(token).getBody();
				claims.forEach((key, value)->{
					System.out.println("key: " + key + " value: " + value);
				});
				}catch (SignatureException | MalformedJwtException | ExpiredJwtException  e) {
					throw new ServletException("2. Invalid Token.");
				}//catch 
		}// if methods
		chain.doFilter(request, response);			
	}//doFilter	
	
}//class JwtFilter