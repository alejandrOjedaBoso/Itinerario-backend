package com.example.demo;

public class Persona {
    private String nombre;
    private String edad;
    private String ciudad;

    public Persona(String nombre, String edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "{\n"+
                "\t\"nombre\":"+"\""+nombre+"\"\n"+
                "\t\"edad\":"+"\""+(Integer.parseInt(edad)+1)+"\"\n"+
                "\t\"ciudad\":"+"\""+ciudad+"\"\n"+
                "}";
    }
}
