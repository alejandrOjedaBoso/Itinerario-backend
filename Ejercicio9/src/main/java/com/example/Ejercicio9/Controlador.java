package com.example.Ejercicio9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @Value("${password}")
    String contra;
    @Value("${url}")
    String enlace;
    @Value("${valor1}")
    String valor1;
    @Value("${valor2}")
    String valor2;

    @GetMapping("/parametros")
    public String parametros(){
        return "Enlace: "+enlace+"\nContraseña: "+contra;
    }
    @GetMapping("/miconfiguracion")
    public String miconfiguracion(){
        return valor1+" "+valor2;
    }
}
