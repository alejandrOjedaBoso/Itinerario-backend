package com.example.Ejercicio4;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controlador1 {
    @Autowired
    Persona persona;

    @GetMapping("/controlador1/addPersona")
    public Persona addPersona(@RequestHeader Map<String,String> cabecera){
        persona.setNombre(cabecera.get("nombre"));
        persona.setPoblacion(cabecera.get("poblacion"));
        persona.setEdad(Integer.parseInt(cabecera.get("edad")));
        return persona;
    }
}
