package com.example.Ejercicio8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @Value("${VAR1}")
    String var1;
    @Value("${My.VAR2}")
    int var2;
    @Value("${VAR3:var3 no tiene valor}")
    String var3;
    @GetMapping("/valores")
    public String devolverValores(){
        return "VAR1: "+var1 +"\nVAR2: "+var2;
    }
    @GetMapping("/var3")
    public String getVar3(){
        return "VAR3: "+var3;
    }
}
