package com.example.Ejercicio9;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public interface Perfiles {
    @GetMapping("/perfil")
    public String miFuncion();
}
