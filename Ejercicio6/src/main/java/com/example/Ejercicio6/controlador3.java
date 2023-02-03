package com.example.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/persona")
@RestController
public class controlador3 {
    @Autowired
    Servicio servicio;

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable int id){
        servicio.borrarPersona(id);
    }
}
