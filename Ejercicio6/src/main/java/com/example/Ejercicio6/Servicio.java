package com.example.Ejercicio6;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Map;

@Service
public class Servicio {
    private ArrayList<Persona> listaPersona=new ArrayList<Persona>();

    public void aniadirPersona(Persona auxiliar){
        listaPersona.add(auxiliar);
    }
    public void cambiarPersona(int id, Map<String,String> mapa){
        Persona aux=new Persona();
        boolean salir=true;
        for (int i = 0; i < listaPersona.size() && salir; i++) {
            if (listaPersona.get(i).getId()==id){
                aux=listaPersona.get(i);
                salir=false;
            }
        }
        if (mapa.get("nombre")!=null) {
            aux.setNombre(mapa.get("nombre"));
        }
        if (mapa.get("edad")!=null) {
            aux.setEdad(Integer.parseInt(mapa.get("edad")));
        }
        if (mapa.get("poblacion")!=null) {
            aux.setPoblacion(mapa.get("poblacion"));
        }
    }
    public void borrarPersona(int id){
        boolean salir = true;
        for (int i = 0; i < listaPersona.size() && salir; i++) {
            if (listaPersona.get(i).getId()==id){
                listaPersona.remove(i);
                salir=false;
            }
        }
    }
    public Persona getId(int id){
        Persona aux=new Persona();
        boolean salir = true;
        for (int i = 0; i < listaPersona.size() && salir; i++) {
            if (listaPersona.get(i).getId()==id){
                aux=listaPersona.get(i);
                salir=false;
            }
        }
        return aux;
    }
    public Persona getNombre(String nombre){
        Persona aux=new Persona();
        boolean salir = true;
        for (int i = 0; i < listaPersona.size() && salir; i++) {
            if (listaPersona.get(i).getNombre().equalsIgnoreCase(nombre)){
                aux=listaPersona.get(i);
                salir=false;
            }
        }
        return aux;
    }
}
