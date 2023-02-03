package Personas;

import java.io.*;
import java.util.*;

public class Run {
    public static void main(String[] args) {
        BufferedReader bR;
        String linea="";
        ArrayList<Persona> listaPersona=new ArrayList<Persona>();
        String[] datos;
        try {
            bR=new BufferedReader(new FileReader(new File("personas.txt")));
            linea=bR.readLine();
            while(linea!=null){
                datos=linea.split(":");
                if(datos.length==3) {
                    listaPersona.add(new Persona(datos[0], datos[1], datos[2]));
                }
                else {
                    listaPersona.add(new Persona(datos[0], datos[1], "-1"));
                }
                linea=bR.readLine();
            }
            bR.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mostrarListaPersonas(listaPersona);
    }

    public static void mostrarListaPersonas(List<Persona> lP){
        lP.stream().filter(persona -> persona.getEdad()<25 && persona.getEdad()>-1).forEach(p-> System.out.println(p.toString()));
    }
}
