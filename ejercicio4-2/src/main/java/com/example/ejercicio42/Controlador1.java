package com.example.ejercicio42;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador1 {
    @Autowired
    ArrayList<Ciudad> listCiudad;

    @PostMapping("/controlador1/addCiudad")
    public void addCiudad(@RequestBody Ciudad c){
        listCiudad.add(c);
    }
}
