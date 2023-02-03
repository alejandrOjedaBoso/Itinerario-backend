package com.example.ejercicio43;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio43Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio43Application.class, args);
	}

	@Bean("bean1")
	public Persona bean1(){
		Persona p=new Persona();
		p.setNombre("Maria");
		return p;
	}
	@Bean("bean2")
	public Persona bean2(){
		Persona p=new Persona();
		p.setNombre("Alex");
		return p;
	}
	@Bean("bean3")
	public Persona bean3(){
		Persona p=new Persona();
		p.setNombre("Javi");
		return p;
	}
}
