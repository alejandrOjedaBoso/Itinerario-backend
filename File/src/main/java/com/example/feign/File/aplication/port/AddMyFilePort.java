package com.example.feign.File.aplication.port;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


public interface AddMyFilePort {
    public String subirArchivo(MultipartFile flujoArchivo) throws IOException;
}
