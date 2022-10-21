package com.generation.DrLomito;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.generation.DrLomito.jwt.config.JwtFilter;

@SpringBootApplication
public class DrLomitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrLomitoApplication.class, args);
	}//main
	
	//@Bean
	//public FilterRegistrationBean<JwtFilter> jwtFilter(){
		//FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
		//registrationBean.setFilter(new JwtFilter());
		//registrationBean.addUrlPatterns("/api/categoria_vet/*");
		//registrationBean.addUrlPatterns("/api/contactoVet/*");
		//registrationBean.addUrlPatterns("/api/info_veterinarios/*");
		//registrationBean.addUrlPatterns("/api/opinionesVet/*");
		//registrationBean.addUrlPatterns("/api/tiposusuario/*");		
		//registrationBean.addUrlPatterns("/api/usuarios/*");
		//return registrationBean;
	//}//nos va a ayudar a filtrar

}//class DrLomitoApplication



