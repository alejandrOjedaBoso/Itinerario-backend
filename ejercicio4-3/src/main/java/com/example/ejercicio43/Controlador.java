package com.example.ejercicio43;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @Autowired
    @Qualifier("bean1")
    Persona p1;

    @Autowired
    @Qualifier("bean2")
    Persona p2;

    @Autowired
    @Qualifier("bean3")
    Persona p3;

    @GetMapping("/controlador/bean/{bean}")
    public String devolverNombre(@PathVariable String bean){
        if (bean.equalsIgnoreCase("bean1")){
            return p1.getNombre();
        }
        else if (bean.equalsIgnoreCase("bean2")){
            return p2.getNombre();
        }
        else if (bean.equalsIgnoreCase("bean3")){
            return p3.getNombre();
        }
        return "Equivocado";
    }
}
