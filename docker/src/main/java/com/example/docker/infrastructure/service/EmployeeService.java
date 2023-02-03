package com.example.docker.infrastructure.service;

import com.example.docker.domain.EmployeeEntitty;

import java.util.List;

public interface EmployeeService {

        List<EmployeeEntitty> findAll();

        void insertEmployee(EmployeeEntitty emp);

        void updateEmployee(EmployeeEntitty emp);

        void executeUpdateEmployee(EmployeeEntitty emp);

        void deleteEmployee(EmployeeEntitty emp);


}
