package com.example.Ejercicio11.domain;

import com.example.Ejercicio11.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.Ejercicio11.infrastucture.exceptions.error422.Request422;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Persona{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id_persona;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_email")
    private String company_email;

    @Column(name = "personal_email")
    private String personal_email;

    @Column(name = "city")
    private String city;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "imagen_url")
    private String imagen_url;

    @Column(name = "termination_date")
    private Date termination_date;

    public Persona() {
    }
    public Persona(PersonaInputDTO personaDTO) throws Exception {
        setId_persona(personaDTO.idPersona());
        setPassword(personaDTO.password());
        setName(personaDTO.name());
        setSurname(personaDTO.surname());
        setCompany_email(personaDTO.companyEmail());
        setPersonal_email(personaDTO.personalEmail());
        setCity(personaDTO.city());
        setActive(personaDTO.active());
        setCreated_date(personaDTO.createdDate());
        setImagen_url(personaDTO.imageUrl());
        setTermination_date(personaDTO.teminationDate());
    }

}
