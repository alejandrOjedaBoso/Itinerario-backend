package com.example.Ejercicio11.domain;

import com.example.Ejercicio11.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.Ejercicio11.infrastucture.exceptions.error422.Request422;
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
        if(usuario==null||password==null||name==null||company_email==null||personal_email==null||city==null||created_date==null){
            throw new Request422("Hay algun campo que no se han itroducido correctamente");
        }
    }

}
