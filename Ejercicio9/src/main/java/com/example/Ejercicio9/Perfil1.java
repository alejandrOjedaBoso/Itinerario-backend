package com.example.Ejercicio9;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("Perfil1")
public class Perfil1 implements Perfiles{
    private String perfil="Perfil1";

    @Override
    public String miFuncion() {
        return perfil;
    }
}
