package com.example.feign.File.infrastucture.repository;

import com.example.feign.File.domain.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MyFileJPA extends JpaRepository<MyFile, Integer> {
    MyFile findByNombre(String nombre);
    List<MyFile> findByExtension(String extension);
}
