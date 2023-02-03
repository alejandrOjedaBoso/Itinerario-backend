package com.example.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RequestMapping("/persona")
@RestController
public class controlador1 {
    @Autowired
    Servicio servicio;

    @PostMapping
    public void aniadirPersona(@RequestBody Persona auxiliar){
        servicio.aniadirPersona(auxiliar);
    }
}
