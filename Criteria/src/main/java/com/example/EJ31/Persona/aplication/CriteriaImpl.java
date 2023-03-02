package com.example.EJ31.Persona.aplication;

import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

@Service
public class CriteriaImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaOutputDTO> getPart1(HashMap<String, Object>){


        return null;
    }
}
