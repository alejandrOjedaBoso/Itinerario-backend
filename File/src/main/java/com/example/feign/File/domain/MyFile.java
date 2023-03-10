package com.example.feign.File.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MyFile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int fileId;

    private String nombre;

    private String extension;
    @Lob
    private byte[] metaDatos;
    private Date creationDate;
}
