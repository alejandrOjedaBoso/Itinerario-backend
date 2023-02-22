package com.example.feign.File.aplication.port;

import com.example.feign.File.infrastucture.controller.DTO.output.MyFileOutputDTO;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface GetMyFilePort {
    public MyFileOutputDTO buscarId(int id);
    public MyFileOutputDTO buscarNombre(String nombre);
    public String descargarId(int id) throws IOException;
    public String decargarNombre(String nombre) throws IOException;
}
