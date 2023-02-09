package com.example.feign.Student.aplication.port;

public interface AsignStudentPort {
    public void asignPersonaId(int idStudent, int idPersona) throws Exception;
    public void asignProfesorId(int idStudent,int idProfesor) throws Exception;
    public void asignAsig(int idStudent, int asig)throws Exception;
    public void desasignAsig(int idStudent,int asig) throws Exception;
}
