package com.example.EJ31.Student.aplication.port;

import java.util.Map;

public interface AsignStudentPort {
    public void asignPersonaId(int idStudent, int idPersona) throws Exception;
    public void asignProfesorId(int idStudent,int idProfesor) throws Exception;
    public void asignAsig(int idStudent, Map<String, Integer> mapaAsig)throws Exception;
    public void desasignAsig(int idStudent,Map<String,Integer>mapaAsig) throws Exception;
}
