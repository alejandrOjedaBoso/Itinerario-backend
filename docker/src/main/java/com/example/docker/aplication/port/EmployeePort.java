package com.example.docker.aplication.port;

import com.example.docker.domain.EmployeeEntitty;

import java.util.List;

public interface EmployeePort {
    List<EmployeeEntitty> findAll();
    void insertEmployee(EmployeeEntitty emp);
    void updateEmployee(EmployeeEntitty emp);
    void executeUpdateEmployee(EmployeeEntitty emp);
    public void deleteEmployee(EmployeeEntitty emp);
}
