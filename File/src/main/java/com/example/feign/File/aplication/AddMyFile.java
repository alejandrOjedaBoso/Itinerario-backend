package com.example.feign.File.aplication;

import com.example.feign.File.aplication.port.AddMyFilePort;
import com.example.feign.File.domain.MyFile;
import com.example.feign.File.infrastucture.repository.MyFileJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
@Service
public class AddMyFile implements AddMyFilePort {
    @Autowired
    MyFileJPA myFileJPA;
    @Override
    public String subirArchivo(MultipartFile flujoArchivo) throws IOException {
        MyFile myFile= new MyFile();
        if (myFileJPA.findByNombre(flujoArchivo.getOriginalFilename())!=null){
            return "Ya existe un archivo con el mismo nombre";
        }
        myFile.setNombre(flujoArchivo.getOriginalFilename());
        myFile.setExtension(flujoArchivo.getContentType());
        myFile.setCreationDate(new Date());
        myFile.setMetaDatos(flujoArchivo.getBytes());

        myFileJPA.save(myFile);
        return "Se ha añadido correctamente";
    }
}
