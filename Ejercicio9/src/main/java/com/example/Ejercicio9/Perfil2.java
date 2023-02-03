package com.example.Ejercicio9;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("Perfil2")
public class Perfil2 implements Perfiles{
    private String perfil="Perfil2";

    @Override
    public String miFuncion() {
       return perfil;
    }
}
