package com.example.Ejercicio4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {
    @Autowired
    Persona persona;

    @GetMapping("/controlador2/getPersona")
    public Persona getPersona(){
        persona.setEdad(persona.getEdad()*2);
        return persona;
    }
}
