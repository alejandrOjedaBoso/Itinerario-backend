package com.example.Ejercicio4;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    private String nombre;
    private String poblacion;
    private int edad;

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return getNombre()+" ; "+getEdad()+" ; "+getPoblacion();
    }
}
