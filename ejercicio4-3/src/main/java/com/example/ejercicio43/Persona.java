package com.example.ejercicio43;

public class Persona {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
