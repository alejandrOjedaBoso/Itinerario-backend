package com.example.EJ31.Persona.aplication;

import com.example.EJ31.Persona.aplication.port.FindUsuarioPort;
import com.example.EJ31.Persona.domain.Persona;
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
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.Metamodel;
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
        List<Persona> listaPersona=personaRepo.findAll();
        List<PersonaOutputDTO> listaDTO= new ArrayList<PersonaOutputDTO>();
        PersonaOutputDTO personaOutputDTO=null;
        for (Persona per: listaPersona) {
            personaOutputDTO=tipoPersona(per);
            if(outputType.equalsIgnoreCase("full")&& personaOutputDTO!=null){
                listaDTO.add(personaOutputDTO);
            }else {
                personaOutputDTO=new PersonaOutputDTO(per);
                listaDTO.add(personaOutputDTO);
            }
        }
        return listaDTO;
    }
    @Override
    public PersonaOutputDTO buscarPorId(int id, String outputType) throws Exception {
        PersonaOutputDTO personaOutputDTO=null,aux=null;
        if(personaRepo.findById(id).isEmpty()){
            throw new Request404("No se ha encontrado");
        }
        Persona per = personaRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        personaOutputDTO=new PersonaOutputDTO(per);
        aux=tipoPersona(per);
        if (aux!=null && outputType.equalsIgnoreCase("full")){
            personaOutputDTO=aux;
        }
        return personaOutputDTO;
    }
    @Override
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre,String outputType) throws Exception {
        List<Persona> listaPersona= personaRepo.findAll();
        ArrayList<PersonaOutputDTO> salidaDTO= new ArrayList<PersonaOutputDTO>();
        PersonaOutputDTO personaOutputDTO=null;
        for (int i = 0; i < listaPersona.size(); i++) {
            if(listaPersona.get(i).getName().equalsIgnoreCase(nombre)){
                personaOutputDTO=tipoPersona(listaPersona.get(i));
                if (outputType.equalsIgnoreCase("full")&&personaOutputDTO!=null){
                    salidaDTO.add(personaOutputDTO);
                }else {
                    personaOutputDTO=new PersonaOutputDTO(listaPersona.get(i));
                    salidaDTO.add(personaOutputDTO);
                }
            }
        }
        if(listaPersona.isEmpty()){
            throw new Exception("No existe el nombre");
        }
        else{
            return salidaDTO;
        }
    }

    @Override
    public List<PersonaOutputDTO> getData(HashMap<String, Object> conditions) throws Exception {
        EntityManager entityManager=new EntityManager() {
            @Override
            public void persist(Object o) {

            }

            @Override
            public <T> T merge(T t) {
                return null;
            }

            @Override
            public void remove(Object o) {

            }

            @Override
            public <T> T find(Class<T> aClass, Object o) {
                return null;
            }

            @Override
            public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
                return null;
            }

            @Override
            public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
                return null;
            }

            @Override
            public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
                return null;
            }

            @Override
            public <T> T getReference(Class<T> aClass, Object o) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public void setFlushMode(FlushModeType flushModeType) {

            }

            @Override
            public FlushModeType getFlushMode() {
                return null;
            }

            @Override
            public void lock(Object o, LockModeType lockModeType) {

            }

            @Override
            public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

            }

            @Override
            public void refresh(Object o) {

            }

            @Override
            public void refresh(Object o, Map<String, Object> map) {

            }

            @Override
            public void refresh(Object o, LockModeType lockModeType) {

            }

            @Override
            public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

            }

            @Override
            public void clear() {

            }

            @Override
            public void detach(Object o) {

            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public LockModeType getLockMode(Object o) {
                return null;
            }

            @Override
            public void setProperty(String s, Object o) {

            }

            @Override
            public Map<String, Object> getProperties() {
                return null;
            }

            @Override
            public Query createQuery(String s) {
                return null;
            }

            @Override
            public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
                return null;
            }

            @Override
            public Query createQuery(CriteriaUpdate criteriaUpdate) {
                return null;
            }

            @Override
            public Query createQuery(CriteriaDelete criteriaDelete) {
                return null;
            }

            @Override
            public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
                return null;
            }

            @Override
            public Query createNamedQuery(String s) {
                return null;
            }

            @Override
            public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
                return null;
            }

            @Override
            public Query createNativeQuery(String s) {
                return null;
            }

            @Override
            public Query createNativeQuery(String s, Class aClass) {
                return null;
            }

            @Override
            public Query createNativeQuery(String s, String s1) {
                return null;
            }

            @Override
            public StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
                return null;
            }

            @Override
            public StoredProcedureQuery createStoredProcedureQuery(String s) {
                return null;
            }

            @Override
            public StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
                return null;
            }

            @Override
            public StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
                return null;
            }

            @Override
            public void joinTransaction() {

            }

            @Override
            public boolean isJoinedToTransaction() {
                return false;
            }

            @Override
            public <T> T unwrap(Class<T> aClass) {
                return null;
            }

            @Override
            public Object getDelegate() {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public EntityTransaction getTransaction() {
                return null;
            }

            @Override
            public EntityManagerFactory getEntityManagerFactory() {
                return null;
            }

            @Override
            public CriteriaBuilder getCriteriaBuilder() {
                return null;
            }

            @Override
            public Metamodel getMetamodel() {
                return null;
            }

            @Override
            public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
                return null;
            }

            @Override
            public EntityGraph<?> createEntityGraph(String s) {
                return null;
            }

            @Override
            public EntityGraph<?> getEntityGraph(String s) {
                return null;
            }

            @Override
            public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
                return null;
            }
        };
        List<Predicate> salida=new List<Predicate>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Predicate> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Predicate predicate) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Predicate> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Predicate> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Predicate get(int index) {
                return null;
            }

            @Override
            public Predicate set(int index, Predicate element) {
                return null;
            }

            @Override
            public void add(int index, Predicate element) {

            }

            @Override
            public Predicate remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Predicate> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Predicate> listIterator(int index) {
                return null;
            }

            @Override
            public List<Predicate> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        List<Persona> personas=new ArrayList<Persona>();
        List<PersonaOutputDTO> personaOutputDTOS=new ArrayList<PersonaOutputDTO>();
        CriteriaBuilder cb= entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query= cb.createQuery(Persona.class);
        Root<Persona> root=query.from(Persona.class);

        conditions.forEach((key,value) ->
        {
            switch (key){
                case "usuario":
                    salida.add(cb.like(root.get(key),(String) value));
                    break;
                case "name":
                    salida.add(cb.like(root.get(key),(String)value));
                    break;
                case "surname":
                    salida.add(cb.like(root.get(key),(String)value));
                    break;
                case "created_date":
                    String dateCondition=(String) conditions.get("dateCondition");
                    switch (dateCondition){
                        case "GREATER_THAN":
                            salida.add(cb.greaterThan(root.<Date>get(key),(Date) value));
                            break;
                        case "LESS_THAN":
                            salida.add(cb.lessThan(root.<Date>get(key),(Date)value));
                            break;
                        case "EQUAL":
                            salida.add(cb.equal(root.<Date>get(key),(Date) value));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(salida.toArray(new Predicate[salida.size()]));
        personas=entityManager.createQuery(query).getResultList();
        for (Persona o:personas) {
            personaOutputDTOS.add(new PersonaOutputDTO(o));
        }
        return personaOutputDTOS;
    }

    private PersonaOutputDTO tipoPersona(Persona per) throws Exception {
        List<Student> listaEstu=studentRepo.findAll();
        List<Profesor> listaProfesors=profesorRepo.findAll();
        PersonaOutputDTO devolver=null;
        Persona aux=null;

        for (Student i:listaEstu) {
            aux=i.getPersona();
            if(aux!=null) {
                if (i.getPersona().getId_persona() == per.getId_persona()) {
                    devolver = new PersonaFullOutPutDTO(per, new StudentOutputDTO(i));
                }
            }
        }
        for (Profesor i:listaProfesors) {
            aux=i.getPersona();
            if(aux!=null) {
                if (i.getPersona().getId_persona() == per.getId_persona()) {
                    devolver = new PersonaFullOutPutDTO(per, new ProfesorOutputDTO(i));
                }
            }
        }
        return devolver;
    }
}
