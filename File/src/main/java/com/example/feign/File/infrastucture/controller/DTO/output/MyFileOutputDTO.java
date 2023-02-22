package com.example.feign.File.infrastucture.controller.DTO.output;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyFileOutputDTO {
    private int fileId;
    private String nombre;
    private String extension;
    private byte[] metaDatos;
    private Date creationDate;
}
