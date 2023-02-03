package com.example.ejercicio42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Ejercicio42Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio42Application.class, args);
	}

	@Bean
 	public ArrayList<Ciudad> listaCiudad(){
		return new ArrayList<Ciudad>();
	}
}
