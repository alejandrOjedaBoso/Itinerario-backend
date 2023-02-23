package com.example.feign.File.infrastucture.controller;

import com.example.feign.File.aplication.port.AddMyFilePort;
import com.example.feign.File.aplication.port.GetMyFilePort;
import com.example.feign.File.domain.MyFile;
import com.example.feign.File.infrastucture.controller.DTO.output.MyFileOutputDTO;
import com.example.feign.File.infrastucture.repository.MyFileJPA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
    @GetMapping("/devolvertipo/{extension}")
    public List<MyFileOutputDTO> devolverTipo(@PathVariable String extension){
        return getMyFilePort.devolverTipo(extension);
    }
    @GetMapping("/mappingid/{id}")
    public ResponseEntity<Object> mapperMyfile(@PathVariable int id){
        MyFileOutputDTO myFile=getMyFilePort.getMapperId(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(myFile.getExtension()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + myFile.getNombre())
                .body(new ByteArrayResource(myFile.getMetaDatos()));
    }
    @GetMapping("/mappingnombre/{nombre}")
    public ResponseEntity<Object> mapperName(@PathVariable String nombre){
        MyFileOutputDTO myFile=getMyFilePort.getMapperName(nombre);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(myFile.getExtension()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + myFile.getNombre())
                .body(new ByteArrayResource(myFile.getMetaDatos()));
    }
}
