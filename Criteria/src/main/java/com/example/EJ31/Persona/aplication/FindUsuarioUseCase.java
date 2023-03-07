package com.example.EJ31.Persona.aplication;

import com.example.EJ31.Persona.aplication.port.FindUsuarioPort;
import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.domain.ePersona;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaFullOutPutDTO;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.EJ31.Persona.infrastucture.exceptions.error404.Request404;
import com.example.EJ31.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.EJ31.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import com.example.EJ31.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import javax.persistence.criteria.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.DataOutput;
import java.util.*;


@Service
public class FindUsuarioUseCase implements FindUsuarioPort {
    @Autowired
    PersonaRepo personaRepo;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ProfesorRepo profesorRepo;
    @Override
    public List<PersonaOutputDTO> todasPersonas(String outputType) throws Exception {
        ArrayList<PersonaOutputDTO> listaDeSalida=new ArrayList<PersonaOutputDTO>();

        for (Persona p:personaRepo.findAll()) {
                listaDeSalida.add(new PersonaOutputDTO(p));
        }
        return listaDeSalida;
    }
    @Override
    public PersonaOutputDTO buscarPorId(int id, String outputType) throws Exception {
        Persona persona=personaRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        PersonaOutputDTO personaOutputDTO;


        //Compruebo si es alumno o profesor y a la vez es full, si no es ninguno de los dos solo devuelve la persona
        if(persona.getProfesor()!=null && outputType.equalsIgnoreCase("full")){
            personaOutputDTO=new PersonaFullOutPutDTO(persona, ePersona.PROFESOR);
        }else if(persona.getStudent()!=null && outputType.equalsIgnoreCase("full")){
            personaOutputDTO=new PersonaFullOutPutDTO(persona, ePersona.ESTUDIANTE);
        }else{
            personaOutputDTO=new PersonaOutputDTO(persona);
        }

        return personaOutputDTO;
    }
    @Override
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre,String outputType) throws Exception {
        ArrayList<PersonaOutputDTO> listaSalida = new ArrayList<>();
        for (Persona p: personaRepo.findByName(nombre)) {
            if(p.getProfesor()!=null && outputType.equalsIgnoreCase("full")){
                listaSalida.add(new PersonaFullOutPutDTO(p, ePersona.PROFESOR));
            }else if(p.getStudent()!=null && outputType.equalsIgnoreCase("full")){
                listaSalida.add(new PersonaFullOutPutDTO(p, ePersona.ESTUDIANTE));
            }else{
                listaSalida.add(new PersonaOutputDTO(p));
            }
        }
        return listaSalida;
    }

    //Criteria Ejercicio1
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Persona> criteriaEj1(HashMap<String, Object> persona, String tipoFecha,String ordenar,int tamano, int numPag) {
        CriteriaBuilder cb= entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query=cb.createQuery(Persona.class);
        Root<Persona> root= query.from(Persona.class);


        List<Predicate> predicates=new ArrayList<>();

        for (Map.Entry<String,Object> entry : persona.entrySet()) {
            String campo=entry.getKey();
            Object valor=entry.getValue();

            if (valor!=null){
                switch(campo){
                    case "usuario":
                        predicates.add(cb.like(root.get(campo),"%"+(String)valor+"%"));
                        break;
                    case "name":
                        predicates.add(cb.like(root.get(campo),"%"+(String)valor+"%"));
                        break;
                    case "surname":
                        predicates.add(cb.like(root.get(campo),"%"+(String)valor+"%"));
                        break;
                    case "created_date":
                        Date fecha=(Date) valor;
                        switch (tipoFecha){

                            case "mayor":
                                predicates.add(cb.greaterThan(root.get(campo).as(Date.class),fecha));
                                break;
                            default:
                                predicates.add(cb.lessThan(root.get(campo).as(Date.class),fecha));
                                break;
                        }
                        break;
                }
            }
        }
        if (ordenar!=null&&(ordenar.equalsIgnoreCase("usuario")||ordenar.equalsIgnoreCase("name"))) {
            query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.desc(root.get(ordenar)));
        }else {
            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        }
        return entityManager.createQuery(query).setMaxResults(tamano).setFirstResult(numPag).getResultList().stream().toList();
    }
}
