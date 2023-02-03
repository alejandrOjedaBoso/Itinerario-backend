package com.example.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/persona")
@RestController
public class controlador4 {
    @Autowired
    Servicio servicio;

    @GetMapping("/{id}")
    public Persona controlador3(@PathVariable int id){
        return servicio.getId(id);
    }
    @GetMapping("/nombre/{nombre}")
    public Persona getNombre(@PathVariable String nombre){
        return servicio.getNombre(nombre);
    }
}
