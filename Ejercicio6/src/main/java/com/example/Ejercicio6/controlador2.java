package com.example.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RequestMapping("/persona")
@RestController
public class controlador2 {
    @Autowired
    Servicio servicio;

    @PutMapping("/{id}")
    public void cambiarPersona(@PathVariable int id, @RequestBody Map<String,String> mapa){
        servicio.cambiarPersona(id,mapa);
    }
}
