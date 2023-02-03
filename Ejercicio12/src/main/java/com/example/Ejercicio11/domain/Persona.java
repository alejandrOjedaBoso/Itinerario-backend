package com.example.Ejercicio11.domain;

import com.example.Ejercicio11.infrastucture.controller.dto.input.PersonaInputDTO;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id_persona;

    // No me deja poner la anotacion size**
    @Column(name = "usuario",length = 10)
    private String usuario;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "surname")
    @NonNull
    private String surname;

    @Column(name = "company_email")
    @NonNull
    private String company_email;

    @Column(name = "personal_email")
    @NonNull
    private String personal_email;

    @Column(name = "city")
    @NonNull
    private String city;

    @Column(name = "active")
    @NonNull
    private boolean active;

    @Column(name = "created_date")
    @NonNull
    private Date created_date;

    @Column(name = "imagen_url")
    private String imagen_url;

    @Column(name = "termination_date")
    private Date termination_date;

    public Persona() {
    }

    public Persona(PersonaInputDTO personaDTO) throws Exception {
        setId_persona(personaDTO.getId_persona());
        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.isActive());
        setCreated_date(personaDTO.getCreated_date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_date(personaDTO.getTermination_date());
        if(usuario==null){
            throw new Exception("Usuario no puede ser nulo");
        }
        if(password==null){
            throw new Exception("Password no puede ser nulo");
        }
        if(name==null){
            throw new Exception("Name no puede ser nulo");
        }
        if(company_email==null){
            throw new Exception("Company email no puede ser nulo");
        }
        if(personal_email==null){
            throw new Exception("Personal email no puede ser nulo");
        }
        if(city==null){
            throw new Exception("City no puede ser nulo");
        }
        if(created_date==null){
            throw new Exception("Created date no puede ser nulo");
        }
    }

}
