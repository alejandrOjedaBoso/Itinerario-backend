package com.example.Ejercicio7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.*;

@SpringBootApplication
public class Ejercicio7Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio7Application.class, args);
	}

	@PostConstruct
	public void primerTexto(){
		System.out.println("Hola desde clase inicial");
	}
	@PreDestroy
	public void textoFinal(){
		System.out.println("ADIOS");
	}
	@Bean
	CommandLineRunner ejecutame() {
		return p -> {
			System.out.println("Linea a ejecutar cuando arranque");
		};

	}
}

