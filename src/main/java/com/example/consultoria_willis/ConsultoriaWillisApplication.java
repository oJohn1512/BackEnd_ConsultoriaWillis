package com.example.consultoria_willis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConsultoriaWillisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultoriaWillisApplication.class, args);
	}

}
