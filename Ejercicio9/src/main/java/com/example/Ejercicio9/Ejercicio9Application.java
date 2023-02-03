package com.example.Ejercicio9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Ejercicio9Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio9Application.class, args);
	}

	@Value("${valor1}")
	String valor1;
	@Value("${valor2}")
	String valor2;
	@PostConstruct
	public void inicio(){
		System.out.println(valor1+" "+valor2);
	}
}
