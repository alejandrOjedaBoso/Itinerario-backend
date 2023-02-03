package com.example.demo;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class Controlador {
    @GetMapping("/user/{nombre}")
    public String getNombre(@PathVariable String nombre){
        return nombre;
    }
    @PostMapping("/useradd")
    public String aniadirUsuario(@RequestBody Persona persona){
        return persona.toString();
    }
}
