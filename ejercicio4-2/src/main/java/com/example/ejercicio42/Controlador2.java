package com.example.ejercicio42;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador2 {
    @Autowired
    ArrayList<Ciudad> listaCiudad;

    @GetMapping("/controlador1/getCiudad")
    public String getCiudades(){
        StringBuilder sb=new StringBuilder();
        for (Ciudad p:listaCiudad) {
            sb.append(p.toString()+"\n");
        }
        return sb.toString();
    }
}
