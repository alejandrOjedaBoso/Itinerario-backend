package com.example.feign.File.aplication;

import com.example.feign.File.aplication.port.GetMyFilePort;
import com.example.feign.File.domain.MyFile;
import com.example.feign.File.infrastucture.controller.DTO.output.MyFileOutputDTO;
import com.example.feign.File.infrastucture.repository.MyFileJPA;
import com.example.feign.Persona.infrastucture.exceptions.error404.Request404;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class GetMyFile implements GetMyFilePort {
    public static final String DESCARGA="./downloads/";
    @Autowired
    MyFileJPA myFileJPA;

    @Override
    public MyFileOutputDTO buscarId(int id) {
        MyFile myFile=myFileJPA.findById(id).orElseThrow(()->new Request404("No existe el id "+id));
        return new MyFileOutputDTO(myFile.getFileId(),myFile.getNombre(),myFile.getExtension(),myFile.getMetaDatos(),myFile.getCreationDate());
    }

    @Override
    public MyFileOutputDTO buscarNombre(String nombre) {
        MyFile myFile= myFileJPA.findByNombre(nombre);
        if (myFile==null){
            throw new Request404("No se ha encontrado ningun archivo con nombre: "+ nombre);
        }
        return new MyFileOutputDTO(myFile.getFileId(),myFile.getNombre(),myFile.getExtension(),myFile.getMetaDatos(),myFile.getCreationDate());
    }

    @Override
    public String descargarId(int id) throws IOException {
        MyFile myFile=myFileJPA.findById(id).orElseThrow(()->new Request404("No existe el id "+id));
        File file=new File(DESCARGA+myFile.getNombre());

        if(file.exists()){
            return "El archivo ya existe";
        }
        new File(DESCARGA).mkdirs();
        FileOutputStream fos=new FileOutputStream(file);
        fos.write(myFile.getMetaDatos());
        fos.close();

        return "Se guardado el archivo correctamente";
    }

    @Override
    public String decargarNombre(String nombre) throws IOException {
        MyFile myFile= myFileJPA.findByNombre(nombre);
        if(myFile==null){
            return "No se ha encontrado nombre: "+nombre;
        }
        File file=new File(DESCARGA+myFile.getNombre());

        if(file.exists()){
            return "El archivo ya existe";
        }
        new File(DESCARGA).mkdirs();
        FileOutputStream fos=new FileOutputStream(file);
        fos.write(myFile.getMetaDatos());
        fos.close();

        return "Se guardado el archivo correctamente";
    }
}
