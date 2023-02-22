package com.example.feign.File.infrastucture.controller;

import com.example.feign.File.aplication.port.AddMyFilePort;
import com.example.feign.File.aplication.port.GetMyFilePort;
import com.example.feign.File.infrastucture.controller.DTO.output.MyFileOutputDTO;
import com.example.feign.File.infrastucture.repository.MyFileJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class MyFileController {
    @Autowired
    AddMyFilePort addMyFilePort;
    @Autowired
    GetMyFilePort getMyFilePort;

    @PostMapping("/subir")
    public String subir(@RequestParam("archivo") MultipartFile flujoArchivo) throws IOException {
        return addMyFilePort.subirArchivo(flujoArchivo);
    }
    @GetMapping("/getid/{id}")
    public MyFileOutputDTO conseguirArchivo(@PathVariable int id){
        return getMyFilePort.buscarId(id);
    }
    @GetMapping("/getnombre/{nombre}")
    public MyFileOutputDTO conseguirPorNombre(@PathVariable String nombre){
        return getMyFilePort.buscarNombre(nombre);
    }
    @GetMapping("/descargarid/{id}")
        public String descargarNombre(@PathVariable int id) throws IOException {
            return getMyFilePort.descargarId(id);
        }
    @GetMapping("/descargarnombre/{nombre}")
    public String descargarNombre(@PathVariable String nombre) throws IOException {
        return getMyFilePort.decargarNombre(nombre);
    }
}
