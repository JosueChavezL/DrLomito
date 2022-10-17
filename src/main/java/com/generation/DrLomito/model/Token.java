package com.generation.DrLomito.model;

public class Token {
	private final String accessToken;

	public Token(String accessToken) {
		super();
		this.accessToken = accessToken;
	}//construtor

	public String getAccessToken() {
		return accessToken;
	}//solo get, por que de hecho el final lo convierte en constante.	

}//clss Token
