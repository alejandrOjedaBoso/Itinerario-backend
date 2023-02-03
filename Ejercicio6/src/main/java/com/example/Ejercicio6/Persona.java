package com.example.Ejercicio6;

public class Persona {
    private String nombre;
    private int edad;
    private String poblacion;
    private int id;

    public Persona() {
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public Persona(String nombre, String edad,String poblacion, String id) {
        this.nombre = nombre;
        this.edad = Integer.parseInt(edad);
        this.poblacion=poblacion;
        this.id = Integer.parseInt(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + nombre + '\'' +
                ", edad=" + edad +
                ", poblacion='" + poblacion + '\'' +
                ", id=" + id +
                '}';
    }
}
